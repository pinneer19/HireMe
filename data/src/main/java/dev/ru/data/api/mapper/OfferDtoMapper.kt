package dev.ru.data.api.mapper

import dev.ru.data.api.model.OfferDto
import dev.ru.domain.model.Offer

fun OfferDto.toOffer(): Offer {
    return Offer(
        id = id,
        title = title.orEmpty(),
        link = link.orEmpty(),
        text = button?.text
    )
}