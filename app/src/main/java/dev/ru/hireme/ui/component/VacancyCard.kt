package dev.ru.hireme.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.domain.model.Vacancy
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle
import dev.ru.hireme.ui.util.toDate
import java.time.format.TextStyle

@Composable
fun VacancyCard(
    vacancy: Vacancy,
    onCardClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val locale = LocalConfiguration.current.locales[0]

    val (month: String, day: Int) = with(vacancy.publishedDate.toDate()) {
        month.getDisplayName(TextStyle.FULL, locale) to dayOfMonth
    }

    val favoriteIconWithTint =
        if (vacancy.isFavorite) ImageVector.vectorResource(id = R.drawable.ic_heart_active) to AppColor.blue
        else ImageVector.vectorResource(id = R.drawable.ic_heart) to AppColor.grey4

    Card(
        onClick = onCardClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = AppColor.grey1)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = favoriteIconWithTint.first,
                tint = favoriteIconWithTint.second,
                contentDescription = stringResource(id = R.string.favorite_icon),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(CircleShape)
                    .clickable { onFavoriteClick() }
                    .padding(8.dp)

            )

            Column(modifier = Modifier.fillMaxWidth()) {
                vacancy.lookingNumber?.let {
                    Text(
                        text = pluralStringResource(id = R.plurals.looking_number, count = it, it),
                        color = AppColor.green,
                    )
                }

                Text(
                    text = vacancy.title,
                    modifier = Modifier.padding(vertical = 10.dp),
                    style = AppTextStyle.title_3,
                )

                Text(
                    text = vacancy.town,
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = AppTextStyle.text_1
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Text(
                        text = vacancy.company,
                        style = AppTextStyle.text_1
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_check_mark),
                        contentDescription = stringResource(id = R.string.company_verification)
                    )
                }

                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_experience),
                        contentDescription = stringResource(id = R.string.company_verification)
                    )

                    Text(
                        text = vacancy.previewText,
                        style = AppTextStyle.text_1
                    )
                }

                Text(
                    text = stringResource(
                        id = R.string.vacancy_date,
                        day,
                        month
                    ),
                    style = AppTextStyle.text_1,
                    color = AppColor.grey3
                )

                Button(
                    onClick = {},
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        disabledContainerColor = AppColor.green
                    ),
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .padding(top = 21.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.apply),
                        style = AppTextStyle.button_text_2
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VacancyCardPreview() {
    VacancyCard(
        vacancy = Vacancy(
            lookingNumber = 10,
            title = "UI/UX Designer",
            isFavorite = true,
            town = "Минск",
            company = "Мобирикс",
            previewText = " ",
            publishedDate = "",
            id = "",
            responsibilities = "- Разработка дизайна Web+App (обязательно Figma)\\n\\n- Работа над созданием и улучшением систем;\\n\\n- Взаимодействие с командами frontend-разработки и backend-разработки",
            description = "Мы разрабатываем мобильные приложения, web-приложения и сайты под ключ.\\n\\nНам в команду нужен UX/UI Designer!",
            schedules = listOf(
                "частичная занятость",
                "полный день"
            ),
            questions = listOf(
                "Где располагается место работы?",
                "Какой график работы?",
                "Как с вами связаться?"
            ),
            salary = "от 60 000 ₽ до вычета налогов"
        ),
        onFavoriteClick = {},
        onCardClick = {}
    )
}