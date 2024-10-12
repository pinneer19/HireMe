package dev.ru.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class VacancyEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    val isFavorite: Boolean,
    val town: String,
    val company: String,
    val previewText: String,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val description: String,
    val schedules: List<String>,
    val salary: String
)