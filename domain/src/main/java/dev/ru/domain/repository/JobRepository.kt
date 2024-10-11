package dev.ru.domain.repository

import dev.ru.domain.model.JobData

interface JobRepository {
    suspend fun getJobData(): Result<JobData>
}