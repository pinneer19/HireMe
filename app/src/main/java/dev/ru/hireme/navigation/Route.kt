package dev.ru.hireme.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    data object Login : Route()

    @Serializable
    data object Search : Route()

    @Serializable
    data class EmailConfirmation(val email: String) : Route()
}