package dev.ru.hireme.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ru.domain.usecase.GetFavoriteVacanciesAmountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomBarViewModel @Inject constructor(
    private val getVacanciesAmountUseCase: GetFavoriteVacanciesAmountUseCase
) : ViewModel() {

    private val _vacanciesAmount = MutableStateFlow(0)
    val vacanciesAmount: StateFlow<Int> = _vacanciesAmount

    init {
        fetchVacanciesAmount()
    }

    private fun fetchVacanciesAmount() {
        viewModelScope.launch {
            getVacanciesAmountUseCase().collect { amount ->
                _vacanciesAmount.value = amount
            }
        }
    }
}