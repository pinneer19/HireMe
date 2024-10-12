package dev.ru.hireme.ui.screen.email_confirmation.viewmodel

sealed class EmailConfirmationEvent {

    data class UpdateCode(val code: String) : EmailConfirmationEvent()

    data class ConfirmCode(val onConfirmCodeSuccess: () -> Unit) : EmailConfirmationEvent()
}