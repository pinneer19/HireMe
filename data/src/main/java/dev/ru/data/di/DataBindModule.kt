package dev.ru.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.ru.data.repository.JobRepositoryImpl
import dev.ru.domain.repository.JobRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataBindModule {

    @Binds
    fun bindJobRepository(repositoryImpl: JobRepositoryImpl): JobRepository
}