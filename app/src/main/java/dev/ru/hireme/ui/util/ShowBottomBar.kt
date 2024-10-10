package dev.ru.hireme.ui.util

import dev.ru.hireme.navigation.Route

fun String.showBottomBar(): Boolean {
    return this != Route.Login::class.qualifiedName.toString()
}