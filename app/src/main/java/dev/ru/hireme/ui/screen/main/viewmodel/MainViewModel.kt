package dev.ru.hireme.ui.screen.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ru.domain.usecase.GetJobDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getJobDataUseCase: GetJobDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState

    init {
        getJobs()
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            MainEvent.UpdateVacanciesVisibility -> updateVacanciesVisibility()
        }
    }

    private fun updateVacanciesVisibility() {
        _uiState.update {
            it.copy(expandedVacancies = !it.expandedVacancies)
        }
    }

    private fun getJobs() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }

            val result = getJobDataUseCase()

            result.onSuccess { jobData ->
                _uiState.update {
                    it.copy(
                        offers = jobData.offers,
                        vacancies = jobData.vacancies,
                        loading = false,
                        error = null
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        loading = false,
                        error = error.message ?: "Unknown error occurred"
                    )
                }
            }
        }
    }
}