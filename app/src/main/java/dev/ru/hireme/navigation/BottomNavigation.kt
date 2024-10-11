package dev.ru.hireme.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.ru.hireme.R

enum class BottomNavigation(
    @StringRes val labelResId: Int,
    @DrawableRes val iconResId: Int,
    val route: Route
) {
    SEARCH(R.string.search, R.drawable.ic_search, Route.Main),
    FAVORITE(R.string.favorite, R.drawable.ic_heart, Route.Favorite),
    APPLICATION(R.string.application, R.drawable.ic_application, Route.Application),
    MESSAGE(R.string.message, R.drawable.ic_message, Route.Message),
    PROFILE(R.string.profile, R.drawable.ic_profile, Route.Profile);

    override fun toString(): String {
        return this::class.qualifiedName.toString()
    }
}