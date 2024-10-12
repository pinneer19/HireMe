package dev.ru.hireme.ui.screen.favorite.viewmodel

import dev.ru.domain.model.Vacancy

data class FavoriteState(
    val favorites: List<Vacancy> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)