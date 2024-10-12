package dev.ru.data.db.mapper

import dev.ru.data.db.entity.VacancyEntity
import dev.ru.domain.model.Vacancy

fun VacancyEntity.toVacancy(): Vacancy {
    return Vacancy(
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