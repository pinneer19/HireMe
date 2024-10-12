package dev.ru.domain.usecase

import dev.ru.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteVacanciesAmountUseCase @Inject constructor(
    private val vacancyRepository: VacancyRepository
) {
    operator fun invoke(): Flow<Int> {
        return vacancyRepository.getVacanciesAmount()
    }
}