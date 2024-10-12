package dev.ru.hireme.ui.screen.favorite.viewmodel

sealed class FavoriteEvent {
    data class RemoveFavoriteVacancy(val id: String) : FavoriteEvent()
}