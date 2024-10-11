package dev.ru.hireme.ui.screen.main

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.screen.main.component.OfferCard
import dev.ru.hireme.ui.screen.main.component.SearchBar
import dev.ru.hireme.ui.screen.main.component.VacancyCard
import dev.ru.hireme.ui.screen.main.viewmodel.MainEvent
import dev.ru.hireme.ui.screen.main.viewmodel.MainState
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun MainScreen(
    uiState: MainState,
    onEvent: (MainEvent) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black)
            .padding(horizontal = 16.dp)
    ) {
        item(key = "Search bar") {
            SearchBar(
                expandedVacancies = uiState.expandedVacancies,
                hideAllVacancies = { onEvent(MainEvent.UpdateVacanciesVisibility) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }

        item(key = "Progress indicator") {
            AnimatedVisibility(visible = uiState.loading) {
                LinearProgressIndicator(
                    color = AppColor.blue,
                    modifier = Modifier.fillMaxWidth(),
                    trackColor = AppColor.grey2
                )
            }
        }

        item(key = "Offers row") {
            AnimatedVisibility(
                visible = !uiState.expandedVacancies,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.offers) { offer ->
                        OfferCard(offer = offer)
                    }
                }
            }
        }

        item(key = "Expanded vacancy list filter") {
            AnimatedVisibility(
                visible = uiState.expandedVacancies,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = pluralStringResource(
                            id = R.plurals.total_vacancies_number,
                            count = uiState.vacancies.size,
                            uiState.vacancies.size
                        ),
                        style = AppTextStyle.text_1
                    )

                    TextButton(
                        onClick = {
                            Toast.makeText(context, R.string.sort_text, Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.sort_text),
                            style = AppTextStyle.text_1,
                            color = AppColor.blue
                        )

                        Icon(
                            imageVector = Icons.Default.UnfoldMore,
                            tint = AppColor.blue,
                            contentDescription = stringResource(id = R.string.unfold_more)
                        )
                    }
                }
            }
        }

        item(key = "Vacancy list title") {
            AnimatedVisibility(
                visible = !uiState.expandedVacancies,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = stringResource(id = R.string.personal_vacancies),
                    style = AppTextStyle.title_2,
                    modifier = Modifier
                        .padding(top = 32.dp, bottom = 16.dp)
                        .animateItem()
                )
            }
        }

        items(
            items = uiState.vacancies.take(3),
            key = { it.id }
        ) {
            VacancyCard(
                vacancy = it,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .animateItem()
            )
        }

        if (uiState.vacancies.size > 3) {
            items(
                items = uiState.vacancies.takeLast(uiState.vacancies.size - 3),
                key = { it.id }
            ) {
                AnimatedVisibility(
                    visible = uiState.expandedVacancies,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    VacancyCard(
                        vacancy = it,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }

            item(key = "Show all vacancies button") {
                AnimatedVisibility(
                    visible = !uiState.expandedVacancies,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColor.blue
                        ),
                        onClick = { onEvent(MainEvent.UpdateVacanciesVisibility) }
                    ) {
                        Text(
                            text = pluralStringResource(
                                id = R.plurals.vacancies_number,
                                count = uiState.vacancies.size - 3,
                                uiState.vacancies.size - 3
                            ),
                            style = AppTextStyle.button_text_2
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    MainScreen(
        uiState = MainState(),
        onEvent = {}
    )
}