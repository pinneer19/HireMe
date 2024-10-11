package dev.ru.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json

@Module(includes = [DataBindModule::class])
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation) {
                register(
                    contentType = ContentType.Application.OctetStream,
                    converter = KotlinxSerializationConverter(
                        Json {
                            ignoreUnknownKeys = true
                        }
                    )
                )
            }
        }
    }
}