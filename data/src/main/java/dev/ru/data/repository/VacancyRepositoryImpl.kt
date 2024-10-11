package dev.ru.data.repository

import dev.ru.data.api.ApiService
import dev.ru.data.mapper.toJobData
import dev.ru.domain.model.JobData
import dev.ru.domain.repository.JobRepository
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): JobRepository {
    override suspend fun getJobData(): Result<JobData> {
        return apiService.getData().map { dto -> dto.toJobData() }
    }
}