package dev.ru.hireme.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.ru.hireme.navigation.Route
import dev.ru.hireme.ui.screen.favorite.viewmodel.FavoriteViewModel

@Composable
fun StatefulFavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FavoriteScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        navigateToVacancyDetails = {
            navController.navigate(Route.VacancyDetails)
        }
    )
}