package dev.ru.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalaryDto(
    @SerialName("full") val full: String? = null
)