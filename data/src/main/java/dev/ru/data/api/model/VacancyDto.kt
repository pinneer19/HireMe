package dev.ru.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VacancyDto(
    @SerialName("id") val id: String? = null,
    @SerialName("lookingNumber") val lookingNumber: Int? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("address") val address: AddressDto? = null,
    @SerialName("company") val company: String? = null,
    @SerialName("experience") val experience: ExperienceDto? = null,
    @SerialName("publishedDate") val publishedDate: String? = null,
    @SerialName("isFavorite") val isFavorite: Boolean? = null,
    @SerialName("salary") val salary: SalaryDto? = null,
    @SerialName("schedules") val schedules: List<String> = listOf(),
    @SerialName("appliedNumber") val appliedNumber: Int? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("responsibilities") val responsibilities: String? = null,
    @SerialName("questions") val questions: List<String> = listOf()
)