package dev.ru.data.api.mapper

import dev.ru.data.api.model.JobDataDto
import dev.ru.domain.model.JobData
import kotlinx.coroutines.Job

fun JobDataDto.toJobData(): JobData {
    return JobData(
        vacancies = vacancies.map { it.toVacancy() },
        offers = offers.map { it.toOffer() }
    )
}