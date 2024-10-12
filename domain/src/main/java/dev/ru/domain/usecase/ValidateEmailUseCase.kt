package dev.ru.domain.usecase

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {
    operator fun invoke(email: String): Boolean {
        return EMAIL_REGEX.toRegex().matches(email)
    }

    companion object {
        private const val EMAIL_REGEX = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+\$"
    }
}