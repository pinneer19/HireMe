package dev.ru.hireme.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.ru.hireme.navigation.Route
import dev.ru.hireme.ui.screen.login.viewmodel.LoginViewModel

@Composable
fun StatefulLoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        onConfirmEmail = { email ->
            navController.navigate(
                Route.EmailConfirmation(email = email)
            )
        }
    )
}