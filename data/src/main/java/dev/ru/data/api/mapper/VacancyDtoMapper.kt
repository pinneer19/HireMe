package dev.ru.data.api.mapper

import dev.ru.data.api.model.VacancyDto
import dev.ru.domain.model.Vacancy

fun VacancyDto.toVacancy(): Vacancy {
    return Vacancy(
        id = id.orEmpty(),
        lookingNumber = lookingNumber,
        title = title.orEmpty(),
        isFavorite = isFavorite ?: false,
        town = address?.town.orEmpty(),
        company = company.orEmpty(),
        previewText = experience?.previewText.orEmpty(),
        publishedDate = publishedDate.orEmpty(),
        schedules = schedules,
        description = description.orEmpty(),
        responsibilities = responsibilities.orEmpty(),
        questions = questions,
        salary = salary?.full.orEmpty()
    )
}