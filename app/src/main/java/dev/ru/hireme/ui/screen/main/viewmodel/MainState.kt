package dev.ru.hireme.ui.screen.main.viewmodel

import dev.ru.domain.model.Offer
import dev.ru.domain.model.Vacancy

data class MainState(
    val offers: List<Offer> = emptyList(),
    val vacancies: List<Vacancy> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null,
    val expandedVacancies: Boolean = false,
)