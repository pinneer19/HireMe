package dev.ru.hireme.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ru.domain.usecase.ValidateEmailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> login(event.onConfirmEmail)
            is LoginEvent.UpdateEmailInput -> updateEmail(event.email)
        }
    }

    private fun login(onConfirmEmail: () -> Unit) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(loading = true)
            }

            val validationResult = validateEmailUseCase(_uiState.value.email)

            _uiState.update {
                if (validationResult) {
                    onConfirmEmail()
                    it.copy(loading = false)
                } else {
                    it.copy(
                        error = "Incorrect email format",
                        loading = false
                    )
                }
            }
        }
    }

    private fun updateEmail(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }
}