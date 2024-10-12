package dev.ru.domain.usecase

import dev.ru.domain.model.Vacancy
import dev.ru.domain.repository.VacancyRepository
import javax.inject.Inject

class AddFavoriteVacancyUseCase @Inject constructor(
    private val vacancyRepository: VacancyRepository
) {
    suspend operator fun invoke(vacancy: Vacancy): Result<Unit> {
        return vacancyRepository.addVacancy(vacancy.copy(isFavorite = true))
    }
}