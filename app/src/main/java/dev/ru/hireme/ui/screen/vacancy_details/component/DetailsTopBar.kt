package dev.ru.hireme.ui.screen.vacancy_details.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor

@Composable
fun DetailsTopBar(
    isFavoriteVacancy: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val favoriteIconWithTint =
        if (isFavoriteVacancy) ImageVector.vectorResource(id = R.drawable.ic_heart_active) to AppColor.blue
        else ImageVector.vectorResource(id = R.drawable.ic_heart) to AppColor.black

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.return_back),
                tint = AppColor.white
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Outlined.Visibility,
            contentDescription = stringResource(id = R.string.return_back),
            tint = AppColor.white
        )

        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = stringResource(id = R.string.return_back),
            modifier = Modifier.padding(horizontal = 16.dp),
            tint = AppColor.white
        )

        Icon(
            imageVector = favoriteIconWithTint.first,
            tint = favoriteIconWithTint.second,
            contentDescription = stringResource(id = R.string.favorite_icon)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsTopBarPreview() {
    DetailsTopBar(
        isFavoriteVacancy = false,
        navigateUp = {}
    )
}