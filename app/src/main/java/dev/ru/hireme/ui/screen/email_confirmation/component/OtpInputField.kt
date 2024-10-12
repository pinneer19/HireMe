package dev.ru.hireme.ui.screen.email_confirmation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputField(
    value: String,
    onValueChange: (String) -> Unit,
    clearFocus: Boolean,
    length: Int,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = clearFocus) {
        if (clearFocus) {
            focusManager.clearFocus()
        }
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(space = 8.dp)) {
                repeat(length) { index ->
                    val number = value.getOrNull(index)
                    val isFocused = value.length == index

                    OtpFieldItem(
                        value = number,
                        isFocused = isFocused
                    )
                }
            }
        }
    )
}