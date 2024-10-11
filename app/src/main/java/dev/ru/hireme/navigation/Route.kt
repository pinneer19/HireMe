package dev.ru.hireme.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    data object Login : Route()

    @Serializable
    data object Main : Route()

    @Serializable
    data class EmailConfirmation(val email: String) : Route()

    @Serializable
    data object Favorite : Route()

    @Serializable
    data object Application : Route()

    @Serializable
    data object Message : Route()

    @Serializable
    data object Profile : Route()
}