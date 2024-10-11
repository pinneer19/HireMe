package dev.ru.domain.model

data class JobData(
    val vacancies: List<Vacancy>,
    val offers: List<Offer>
)