package dev.ru.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalaryDto(
    @SerialName("full") val full: String? = null
)