package dev.ru.data.api

import dev.ru.data.api.model.JobDataDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class ApiService @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getData(): Result<JobDataDto> {
        return runCatching<ApiService, JobDataDto> {
            httpClient.get(JSON_DOCUMENT).body()
        }
            .onFailure {
                println(it)
            }
    }

    companion object {
        private const val JSON_DOCUMENT =
            "https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download"
    }
}