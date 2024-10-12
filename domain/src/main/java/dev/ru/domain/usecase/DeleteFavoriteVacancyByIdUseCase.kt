package dev.ru.domain.usecase

import dev.ru.domain.repository.VacancyRepository
import javax.inject.Inject

class DeleteFavoriteVacancyByIdUseCase @Inject constructor(
    private val vacancyRepository: VacancyRepository
) {
    suspend operator fun invoke(vacancyId: String): Result<Unit> {
        return vacancyRepository.deleteVacancyById(vacancyId = vacancyId)
    }
}