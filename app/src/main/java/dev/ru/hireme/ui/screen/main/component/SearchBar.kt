package dev.ru.hireme.ui.screen.main.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.component.InputTextField
import dev.ru.hireme.ui.theme.AppColor

@Composable
fun SearchBar(
    expandedVacancies: Boolean,
    hideAllVacancies: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val leadingIconWithAction =
        if (expandedVacancies) Icons.AutoMirrored.Default.ArrowBack to hideAllVacancies
        else ImageVector.vectorResource(id = R.drawable.ic_search) to null
    val placeholderText =
        if (expandedVacancies) stringResource(id = R.string.expanded_search_placeholder)
        else stringResource(id = R.string.search_placeholder)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        InputTextField(
            value = "",
            onValueChange = {},
            enabled = false,
            placeholderText = placeholderText,
            leadingIcon = leadingIconWithAction.first,
            leadingIconAction = leadingIconWithAction.second,
            modifier = Modifier.weight(1f)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColor.grey2)
        ) {
            IconButton(
                onClick = {
                    Toast.makeText(context, R.string.vacancy_filter, Toast.LENGTH_SHORT)
                        .show()
                }
            ) {
                Icon(
                    modifier = Modifier.size(33.6.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                    contentDescription = stringResource(id = R.string.vacancy_filter)
                )

            }
        }
    }
}