package dev.ru.hireme.ui.screen.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ru.domain.usecase.DeleteFavoriteVacancyByIdUseCase
import dev.ru.domain.usecase.GetFavoriteVacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val getFavoriteVacanciesUseCase: GetFavoriteVacanciesUseCase,
    val deleteFavoriteVacancyByIdUseCase: DeleteFavoriteVacancyByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoriteState())
    val uiState: StateFlow<FavoriteState> = _uiState

    init {
        observeVacancies()
    }

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.RemoveFavoriteVacancy -> removeFavoriteVacancy(event.id)
        }
    }

    private fun observeVacancies() {
        viewModelScope.launch {
            getFavoriteVacanciesUseCase().collect { vacancies ->
                _uiState.update {
                    it.copy(
                        favorites = vacancies.map { vacancy ->
                            vacancy.copy(isFavorite = true)
                        }
                    )
                }
            }
        }
    }

    private fun removeFavoriteVacancy(vacancyId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }

            val result = deleteFavoriteVacancyByIdUseCase(vacancyId)

            result.onSuccess {
                _uiState.update {
                    it.copy(loading = false)
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        error = error.message,
                        loading = false
                    )
                }
            }
        }
    }
}