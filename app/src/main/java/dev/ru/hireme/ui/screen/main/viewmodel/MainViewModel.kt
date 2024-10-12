package dev.ru.hireme.ui.screen.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ru.domain.model.Vacancy
import dev.ru.domain.usecase.AddFavoriteVacancyUseCase
import dev.ru.domain.usecase.CheckVacancyFavoriteStatus
import dev.ru.domain.usecase.DeleteFavoriteVacancyByIdUseCase
import dev.ru.domain.usecase.GetJobDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getJobDataUseCase: GetJobDataUseCase,
    private val addFavoriteVacancyUseCase: AddFavoriteVacancyUseCase,
    private val deleteFavoriteVacancyByIdUseCase: DeleteFavoriteVacancyByIdUseCase,
    private val checkVacancyFavoriteStatus: CheckVacancyFavoriteStatus
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState

    init {
        getJobs()
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            MainEvent.UpdateVacanciesVisibility -> updateVacanciesVisibility()

            is MainEvent.SaveVacancyToFavorites -> updateVacancyFavoriteStatus(event.vacancy)
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
                        vacancies = jobData.vacancies.map { vacancy ->
                            val isFavorite =
                                checkVacancyFavoriteStatus(vacancy.id).getOrDefault(false)

                            vacancy.copy(isFavorite = isFavorite)
                        },
                        loading = false,
                        error = null
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        loading = false, error = error.message
                    )
                }
            }
        }
    }

    private fun updateVacanciesVisibility() {
        _uiState.update {
            it.copy(expandedVacancies = !it.expandedVacancies)
        }
    }

    private fun updateVacancyFavoriteStatus(vacancy: Vacancy) {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }

            val result = if (vacancy.isFavorite) {
                deleteFavoriteVacancyByIdUseCase(vacancyId = vacancy.id)
            } else {
                addFavoriteVacancyUseCase(vacancy)
            }

            result.onSuccess {
                _uiState.update { state ->
                    val updatedVacancies = state.vacancies.toMutableList()
                    val index = updatedVacancies.indexOfFirst { it.id == vacancy.id }

                    if (index != -1) {
                        updatedVacancies[index] =
                            updatedVacancies[index].copy(isFavorite = !vacancy.isFavorite)
                    }

                    state.copy(
                        loading = false, error = null, vacancies = updatedVacancies
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        loading = false, error = error.message
                    )
                }
            }
        }
    }
}