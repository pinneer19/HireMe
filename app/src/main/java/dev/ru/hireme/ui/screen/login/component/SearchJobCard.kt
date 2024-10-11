package dev.ru.hireme.ui.screen.login.component

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.component.InputTextField
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun SearchJobCard(
    email: String,
    error: String?,
    onEmailUpdate: (String) -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = AppColor.grey1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.search_job),
                style = AppTextStyle.title_3
            )

            InputTextField(
                value = email,
                onValueChange = onEmailUpdate,
                placeholderText = stringResource(id = R.string.email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .then(
                        error?.let {
                            Modifier.border(
                                width = 1.dp,
                                color = AppColor.red,
                                shape = RoundedCornerShape(8.dp)
                            )
                        } ?: Modifier.padding(bottom = 16.dp)
                    ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )

            AnimatedVisibility(
                visible = error != null,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = error.orEmpty(),
                    style = AppTextStyle.title_4,
                    color = AppColor.red
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    enabled = email.isNotEmpty(),
                    onClick = onLogin,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColor.blue,
                        disabledContainerColor = AppColor.dark_blue
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.continueText),
                        style = AppTextStyle.button_text_2,
                        color = if (email.isNotEmpty()) AppColor.white else AppColor.grey4
                    )
                }

                Text(
                    text = stringResource(id = R.string.login_with_password),
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(align = Alignment.End)
                        .clickable(
                            indication = null,
                            interactionSource = remember {
                                MutableInteractionSource()
                            }
                        ) {
                            Toast
                                .makeText(
                                    context,
                                    R.string.login_with_password,
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        },
                    color = AppColor.blue,
                    style = AppTextStyle.button_text_2
                )
            }
        }
    }
}