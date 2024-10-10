package dev.ru.hireme.ui.screen.login

sealed class LoginEvent {

    data class UpdateEmailInput(val email: String) : LoginEvent()

    data class Login(val onConfirmEmail: () -> Unit) : LoginEvent()
}