package dev.ru.domain.repository

import dev.ru.domain.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface VacancyRepository {

    fun getVacancies(): Flow<List<Vacancy>>

    fun getVacanciesAmount(): Flow<Int>

    suspend fun addVacancy(vacancy: Vacancy): Result<Unit>

    suspend fun deleteVacancyById(vacancyId: String): Result<Unit>

    suspend fun checkVacancyFavoriteStatus(vacancyId: String): Result<Boolean>
}