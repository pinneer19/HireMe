package dev.ru.hireme.ui.screen.login.viewmodel

data class LoginState(
    val email: String = "",
    val loading: Boolean = false,
    val error: String? = null
)