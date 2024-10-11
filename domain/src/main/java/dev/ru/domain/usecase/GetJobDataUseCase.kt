package dev.ru.domain.usecase

import dev.ru.domain.model.JobData
import dev.ru.domain.repository.JobRepository
import javax.inject.Inject

class GetJobDataUseCase @Inject constructor(
    private val jobRepository: JobRepository
) {
    suspend operator fun invoke(): Result<JobData> {
        return jobRepository.getJobData()
    }
}