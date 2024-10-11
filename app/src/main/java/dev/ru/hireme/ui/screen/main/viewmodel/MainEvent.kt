package dev.ru.hireme.ui.screen.main.viewmodel

sealed class MainEvent {
    data object UpdateVacanciesVisibility : MainEvent()
}