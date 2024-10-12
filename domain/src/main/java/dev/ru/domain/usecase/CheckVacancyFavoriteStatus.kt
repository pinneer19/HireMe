package dev.ru.domain.usecase

import dev.ru.domain.repository.VacancyRepository
import javax.inject.Inject

class CheckVacancyFavoriteStatus @Inject constructor(
    private val vacancyRepository: VacancyRepository
) {
    suspend operator fun invoke(vacancyId: String): Result<Boolean> {
        return vacancyRepository.checkVacancyFavoriteStatus(vacancyId = vacancyId)
    }
}