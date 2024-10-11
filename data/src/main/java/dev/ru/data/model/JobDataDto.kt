package dev.ru.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobDataDto(
    @SerialName("offers") val offers: List<OfferDto> = listOf(),
    @SerialName("vacancies") val vacancies: List<VacancyDto> = listOf()
)