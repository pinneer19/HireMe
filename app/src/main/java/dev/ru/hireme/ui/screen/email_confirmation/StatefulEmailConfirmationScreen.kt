package dev.ru.hireme.ui.screen.email_confirmation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.ru.hireme.navigation.Route
import dev.ru.hireme.ui.screen.email_confirmation.viewmodel.EmailConfirmationViewModel

@Composable
fun StatefulEmailConfirmationScreen(
    navController: NavController,
    viewModel: EmailConfirmationViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    EmailConfirmationScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        onConfirmCodeSuccess = {
            navController.navigate(Route.Search) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }
    )
}