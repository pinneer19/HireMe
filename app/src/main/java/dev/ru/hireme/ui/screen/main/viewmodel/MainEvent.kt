package dev.ru.hireme.ui.screen.main.viewmodel

import dev.ru.domain.model.Vacancy

sealed class MainEvent {

    data object UpdateVacanciesVisibility : MainEvent()

    data class SaveVacancyToFavorites(val vacancy: Vacancy) : MainEvent()
}