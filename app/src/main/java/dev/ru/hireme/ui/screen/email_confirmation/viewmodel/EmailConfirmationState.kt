package dev.ru.hireme.ui.screen.email_confirmation.viewmodel

data class EmailConfirmationState(
    val email: String = "",
    val code: String = "",
    val maxCodeLength: Int = 4,
    val codeFilled: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)