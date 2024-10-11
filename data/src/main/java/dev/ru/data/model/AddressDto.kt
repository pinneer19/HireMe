package dev.ru.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    @SerialName("town") val town: String? = null,
    @SerialName("street") val street: String? = null,
    @SerialName("house") val house: String? = null
)