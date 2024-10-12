package dev.ru.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDto(
    @SerialName("id") val id: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("link") val link: String? = null,
    @SerialName("button") val button: ButtonDto? = null,
)