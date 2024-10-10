package dev.ru.hireme.ui.screen.login

data class LoginState(
    val email: String = "",
    val loading: Boolean = false,
    val error: String? = null
)