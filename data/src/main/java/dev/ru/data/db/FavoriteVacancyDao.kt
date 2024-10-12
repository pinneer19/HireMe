package dev.ru.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.ru.data.db.entity.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteVacancyDao {

    @Query("SELECT * FROM favorites")
    fun getFavoriteVacancies(): Flow<List<VacancyEntity>>

    @Query("SELECT COUNT(*) FROM favorites")
    fun getFavoriteVacanciesAmount(): Flow<Int>

    @Query("SELECT EXISTS(SELECT * FROM favorites WHERE id = :id)")
    suspend fun isVacancyFavorite(id: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteVacancy(vacancyEntity: VacancyEntity)

    @Query("DELETE FROM favorites WHERE id = :id")
    suspend fun deleteFavoriteVacancyById(id: String)
}