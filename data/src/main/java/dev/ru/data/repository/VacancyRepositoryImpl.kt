package dev.ru.data.repository

import dev.ru.data.db.FavoriteVacancyDao
import dev.ru.data.db.mapper.toEntity
import dev.ru.data.db.mapper.toVacancy
import dev.ru.domain.model.Vacancy
import dev.ru.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VacancyRepositoryImpl @Inject constructor(
    private val vacancyDao: FavoriteVacancyDao
) : VacancyRepository {
    override fun getVacancies(): Flow<List<Vacancy>> {
        return vacancyDao.getFavoriteVacancies()
            .map { entityList ->
                entityList.map { it.toVacancy() }
            }
    }

    override fun getVacanciesAmount(): Flow<Int> {
        return vacancyDao.getFavoriteVacanciesAmount()
    }

    override suspend fun addVacancy(vacancy: Vacancy): Result<Unit> {
        return runCatching {
            vacancyDao.addFavoriteVacancy(vacancy.toEntity())
        }
    }

    override suspend fun deleteVacancyById(vacancyId: String): Result<Unit> {
        return runCatching {
            vacancyDao.deleteFavoriteVacancyById(vacancyId)
        }
    }

    override suspend fun checkVacancyFavoriteStatus(vacancyId: String): Result<Boolean> {
        return runCatching {
            vacancyDao.isVacancyFavorite(id = vacancyId)
        }
    }
}