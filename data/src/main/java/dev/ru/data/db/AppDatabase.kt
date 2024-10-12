package dev.ru.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.ru.data.db.entity.VacancyEntity
import dev.ru.data.db.util.Converters

@Database(version = 1, entities = [VacancyEntity::class])
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val vacancyDao: FavoriteVacancyDao
}