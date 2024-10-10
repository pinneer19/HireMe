package dev.ru.hireme.ui.screen.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun LoginScreen(
    uiState: LoginState,
    onEvent: (LoginEvent) -> Unit,
    onConfirmEmail: () -> Unit
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val error = uiState.error
    LaunchedEffect(key1 = error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login_to_account),
            style = AppTextStyle.title_2,
            modifier = Modifier.padding(top = 32.dp)
        )

        Spacer(modifier = Modifier.height(144.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
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

                TextField(
                    value = uiState.email,
                    onValueChange = { onEvent(LoginEvent.UpdateEmailInput(it)) },
                    placeholder = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = AppColor.grey2,
                        unfocusedTextColor = AppColor.white,
                        unfocusedPlaceholderColor = AppColor.grey4,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = AppColor.grey2.copy(alpha = 0.8f),
                        focusedTextColor = AppColor.white
                    ),
                    textStyle = AppTextStyle.text_1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        enabled = uiState.email.isNotEmpty(),
                        onClick = {
                            onEvent(LoginEvent.Login(onConfirmEmail = onConfirmEmail))
                        },
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
                            color = if (uiState.email.isNotEmpty()) AppColor.white else AppColor.grey4
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

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
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

                Text(
                    text = stringResource(id = R.string.job_posting_and_resume_access),
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                    style = AppTextStyle.button_text_2
                )

                Button(
                    onClick = {
                        Toast.makeText(context, R.string.searching_employees, Toast.LENGTH_SHORT)
                            .show()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = AppColor.white,
                        containerColor = AppColor.green
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.searching_employees)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginState(),
        onEvent = {},
        onConfirmEmail = {}
    )
}