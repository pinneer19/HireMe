package dev.ru.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.ru.data.repository.JobRepositoryImpl
import dev.ru.data.repository.VacancyRepositoryImpl
import dev.ru.domain.repository.JobRepository
import dev.ru.domain.repository.VacancyRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataBindModule {

    @Binds
    fun bindJobRepository(repositoryImpl: JobRepositoryImpl): JobRepository

    @Binds
    fun bindVacancyRepository(repositoryImpl: VacancyRepositoryImpl): VacancyRepository
}