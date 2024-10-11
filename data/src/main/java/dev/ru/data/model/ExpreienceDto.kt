package dev.ru.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceDto(
    @SerialName("previewText") val previewText: String? = null,
    @SerialName("text") val text: String? = null
)