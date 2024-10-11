package dev.ru.data.mapper

import dev.ru.data.model.JobDataDto
import dev.ru.domain.model.JobData
import kotlinx.coroutines.Job

fun JobDataDto.toJobData(): JobData {
    return JobData(
        vacancies = vacancies.map { it.toVacancy() },
        offers = offers.map { it.toOffer() }
    )
}