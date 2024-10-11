package dev.ru.hireme.ui.screen.email_confirmation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = EmailConfirmationViewModel.Factory::class)
class EmailConfirmationViewModel @AssistedInject constructor(
    @Assisted val email: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        EmailConfirmationState(email = email)
    )
    val uiState: StateFlow<EmailConfirmationState> = _uiState

    fun onEvent(event: EmailConfirmationEvent) {
        when (event) {

            is EmailConfirmationEvent.UpdateCode -> updateCode(event.code)

            is EmailConfirmationEvent.ConfirmCode -> confirmCode(event.onConfirmCodeSuccess)
        }
    }

    private fun updateCode(code: String) {
        _uiState.update { state ->
            with(state) {
                when {
                    code.length > maxCodeLength -> state
                    code.length == maxCodeLength -> copy(code = code, codeFilled = true)
                    else -> copy(code = code, codeFilled = false)
                }
            }
        }
    }

    private fun confirmCode(onSuccess: () -> Unit) {
        viewModelScope.launch {
            toggleLoading()

            delay(1000) // simulating api call

            toggleLoading()
            onSuccess()
        }
    }

    private fun toggleLoading() {
        _uiState.update {
            it.copy(loading = !it.loading)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(id: String): EmailConfirmationViewModel
    }
}