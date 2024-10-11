package dev.ru.hireme.ui.util

import dev.ru.hireme.navigation.Route

fun String.showBottomBar(): Boolean {
    return this !in listOf(
        Route.Login::class.qualifiedName.toString(),
        Route.EmailConfirmation::class.qualifiedName.toString()
    )
}

fun String.getSubstringBeforeRouteSymbols(): String {
    val regex = Regex("([^?/]+)")
    return regex.find(this)?.value ?: this
}