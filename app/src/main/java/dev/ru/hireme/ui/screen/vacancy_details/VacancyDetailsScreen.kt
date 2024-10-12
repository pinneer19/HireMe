package dev.ru.hireme.ui.screen.vacancy_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.domain.model.Vacancy
import dev.ru.hireme.R
import dev.ru.hireme.ui.screen.vacancy_details.component.CompanyCard
import dev.ru.hireme.ui.screen.vacancy_details.component.DetailsTopBar
import dev.ru.hireme.ui.screen.vacancy_details.component.VacancyStatistics
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle
import dev.ru.hireme.ui.util.VacancyPlaceholder

@Composable
fun VacancyDetailsScreen(
    vacancy: Vacancy,
    navigateUp: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        DetailsTopBar(
            isFavoriteVacancy = vacancy.isFavorite,
            modifier = Modifier.fillMaxWidth(),
            navigateUp = navigateUp
        )

        Text(
            text = vacancy.title,
            style = AppTextStyle.title_1,
            modifier = Modifier.padding(top = 26.dp)
        )

        Text(
            text = vacancy.salary,
            style = AppTextStyle.text_1,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = vacancy.previewText,
            style = AppTextStyle.text_1
        )

        Text(
            text = vacancy.schedules
                .joinToString(", ")
                .replaceFirstChar { it.titlecase() },
            style = AppTextStyle.text_1,
            modifier = Modifier.padding(top = 6.dp)
        )

        VacancyStatistics(modifier = Modifier.fillMaxWidth())

        CompanyCard(
            company = vacancy.company,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = vacancy.description,
            style = AppTextStyle.text_1,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = stringResource(R.string.your_tasks),
            style = AppTextStyle.title_2
        )

        Text(
            text = vacancy.responsibilities,
            style = AppTextStyle.text_1,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        Text(
            text = stringResource(R.string.ask_question),
            style = AppTextStyle.title_4
        )

        Text(
            text = stringResource(R.string.question_receiving_with_application),
            style = AppTextStyle.title_4,
            color = AppColor.grey3,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        vacancy.questions.forEach {
            Text(
                text = it,
                style = AppTextStyle.title_4,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(AppColor.grey2)
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            )
        }

        Button(
            onClick = {},
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = AppColor.green
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.apply),
                style = AppTextStyle.button_text_2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VacancyDetailsScreenPreview() {
    VacancyDetailsScreen(
        vacancy = VacancyPlaceholder,
        navigateUp = {}
    )
}