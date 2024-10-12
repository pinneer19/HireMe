package dev.ru.hireme.ui.screen.vacancy_details.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun VacancyStatistics(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .height(64.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColor.dark_green)
                .padding(8.dp)
                .weight(1f),
        ) {
            Text(
                text = stringResource(R.string.applied_people),
                style = AppTextStyle.text_1,
                modifier = Modifier.weight(1f)
            )

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_applied),
                modifier = Modifier.size(22.dp),
                contentDescription = stringResource(id = R.string.applied_icon),
            )
        }

        Row(
            modifier = Modifier
                .height(64.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColor.dark_green)
                .padding(8.dp)
                .weight(1f),
        ) {
            Text(
                text = stringResource(R.string.two_people_are_looking_now),
                style = AppTextStyle.text_1,
                modifier = Modifier.weight(1f)
            )

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_looking),
                modifier = Modifier.size(22.dp),
                contentDescription = stringResource(id = R.string.looking_icon),
            )
        }
    }
}