package dev.ru.domain.usecase

import dev.ru.domain.model.Vacancy
import dev.ru.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteVacanciesUseCase @Inject constructor(
    private val vacancyRepository: VacancyRepository
) {
    operator fun invoke(): Flow<List<Vacancy>> {
        return vacancyRepository.getVacancies()
    }
}