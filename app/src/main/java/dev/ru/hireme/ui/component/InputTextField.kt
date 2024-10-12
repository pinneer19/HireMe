package dev.ru.hireme.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    leadingIconAction: (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholderText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingIcon = leadingIcon?.let { icon ->
            {
                leadingIconAction?.let {
                    IconButton(onClick = leadingIconAction) {
                        Icon(
                            imageVector = icon,
                            tint = AppColor.white,
                            contentDescription = stringResource(id = R.string.leading_icon)
                        )
                    }
                } ?: Icon(
                    imageVector = icon,
                    contentDescription = stringResource(id = R.string.leading_icon)
                )
            }
        },
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppColor.grey2,
            disabledContainerColor = AppColor.grey2,
            unfocusedTextColor = AppColor.white,
            disabledTextColor = AppColor.white,
            disabledLeadingIconColor = AppColor.grey4,
            unfocusedPlaceholderColor = AppColor.grey4,
            disabledPlaceholderColor = AppColor.grey4,
            unfocusedIndicatorColor = AppColor.transparent,
            focusedIndicatorColor = AppColor.transparent,
            disabledIndicatorColor = AppColor.transparent,
            focusedContainerColor = AppColor.grey2.copy(alpha = 0.8f),
            focusedTextColor = AppColor.white,
            unfocusedLeadingIconColor = AppColor.grey4,
            focusedLeadingIconColor = AppColor.white,
        ),
        textStyle = AppTextStyle.text_1,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        enabled = enabled,
    )
}