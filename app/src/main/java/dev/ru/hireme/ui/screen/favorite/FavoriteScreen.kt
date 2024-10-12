package dev.ru.hireme.ui.screen.favorite

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.navigation.Route
import dev.ru.hireme.ui.component.VacancyCard
import dev.ru.hireme.ui.screen.favorite.viewmodel.FavoriteEvent
import dev.ru.hireme.ui.screen.favorite.viewmodel.FavoriteState
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun FavoriteScreen(
    uiState: FavoriteState,
    onEvent: (FavoriteEvent) -> Unit,
    navigateToVacancyDetails: () -> Unit
) {
    val context = LocalContext.current
    val error = uiState.error

    LaunchedEffect(key1 = error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black),
        contentPadding = PaddingValues(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.favorite),
                style = AppTextStyle.title_2,
            )
        }

        item {
            Text(
                text = pluralStringResource(
                    id = R.plurals.total_vacancies_number,
                    count = uiState.favorites.size,
                    uiState.favorites.size
                ),
                style = AppTextStyle.text_1,
                color = AppColor.grey3,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
            )
        }

        item {
            AnimatedVisibility(
                visible = uiState.loading,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkHorizontally()
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = AppColor.blue)
                }
            }
        }

        items(
            items = uiState.favorites,
            key = { it.id }
        ) { vacancy ->
            VacancyCard(
                vacancy = vacancy,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .animateItem(),
                onFavoriteClick = {
                    onEvent(
                        FavoriteEvent.RemoveFavoriteVacancy(id = vacancy.id)
                    )
                },
                onCardClick = navigateToVacancyDetails
            )
        }
    }
}