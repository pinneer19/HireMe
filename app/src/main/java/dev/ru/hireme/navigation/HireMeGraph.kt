package dev.ru.hireme.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.ru.hireme.ui.screen.email_confirmation.StatefulEmailConfirmationScreen
import dev.ru.hireme.ui.screen.email_confirmation.viewmodel.EmailConfirmationViewModel
import dev.ru.hireme.ui.screen.favorite.StatefulFavoriteScreen
import dev.ru.hireme.ui.screen.login.StatefulLoginScreen
import dev.ru.hireme.ui.screen.main.StatefulMainScreen
import dev.ru.hireme.ui.screen.vacancy_details.VacancyDetailsScreen
import dev.ru.hireme.ui.util.BottomBarViewModel
import dev.ru.hireme.ui.util.ScreenPlaceholder
import dev.ru.hireme.ui.util.VacancyPlaceholder
import dev.ru.hireme.ui.util.getSubstringBeforeRouteSymbols
import dev.ru.hireme.ui.util.showBottomBar

@Composable
fun HireMeGraph(bottomBarViewModel: BottomBarViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val vacanciesAmount by bottomBarViewModel.vacanciesAmount.collectAsState()

    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavigation.SEARCH.toString()

    val currentRouteTrimmed by remember(currentRoute) {
        derivedStateOf { currentRoute.getSubstringBeforeRouteSymbols() }
    }

    val showBottomBar by remember(currentRouteTrimmed) {
        derivedStateOf { currentRouteTrimmed.showBottomBar() }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomBar,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                MainBottomBar(
                    currentRoute = currentRoute,
                    onNavigationBarItemClick = { itemRoute ->
                        if (currentRoute != itemRoute::class.qualifiedName) {
                            navController.navigate(itemRoute) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    vacanciesAmount = vacanciesAmount
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Route.Main
        ) {
            composable<Route.Login> {
                StatefulLoginScreen(navController)
            }

            composable<Route.EmailConfirmation> { backStackEntry ->
                val email = backStackEntry.toRoute<Route.EmailConfirmation>().email
                val viewModel =
                    hiltViewModel<EmailConfirmationViewModel, EmailConfirmationViewModel.Factory> { factory ->
                        factory.create(email)
                    }

                StatefulEmailConfirmationScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable<Route.Main> {
                StatefulMainScreen(navController = navController)
            }

            composable<Route.Message> {
                ScreenPlaceholder(title = "Сообщения")
            }

            composable<Route.Profile> {
                ScreenPlaceholder(title = "Профиль")
            }

            composable<Route.Application> {
                ScreenPlaceholder(title = "Отклики")
            }

            composable<Route.Favorite> {
                StatefulFavoriteScreen(navController = navController)
            }

            composable<Route.VacancyDetails> {
                VacancyDetailsScreen(
                    vacancy = VacancyPlaceholder,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    }
}