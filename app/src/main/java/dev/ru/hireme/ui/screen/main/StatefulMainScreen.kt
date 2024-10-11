package dev.ru.hireme.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import dev.ru.hireme.ui.screen.main.viewmodel.MainViewModel

@Composable
fun StatefulMainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MainScreen(uiState = uiState, onEvent = viewModel::onEvent)
}