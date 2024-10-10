package dev.ru.hireme.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.ru.hireme.R

enum class BottomNavigation(
    @StringRes val labelResId: Int,
    @DrawableRes val iconResId: Int,
    val route: Route
) {
    SEARCH(R.string.search, R.drawable.ic_search, Route.Search);

    override fun toString(): String {
        return this::class.qualifiedName.toString()
    }
}