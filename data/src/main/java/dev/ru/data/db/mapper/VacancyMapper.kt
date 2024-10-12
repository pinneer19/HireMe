package dev.ru.data.db.mapper

import dev.ru.data.db.entity.VacancyEntity
import dev.ru.domain.model.Vacancy

fun Vacancy.toEntity(): VacancyEntity {
    return VacancyEntity(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        isFavorite = isFavorite,
        town = town,
        company = company,
        previewText = previewText,
        publishedDate = publishedDate,
        questions = questions,
        responsibilities = responsibilities,
        description = description,
        schedules = schedules,
        salary = salary
    )
}