package dev.ru.hireme.ui.screen.email_confirmation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.screen.email_confirmation.component.OtpInputField
import dev.ru.hireme.ui.screen.email_confirmation.viewmodel.EmailConfirmationEvent
import dev.ru.hireme.ui.screen.email_confirmation.viewmodel.EmailConfirmationState
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun EmailConfirmationScreen(
    uiState: EmailConfirmationState,
    onEvent: (EmailConfirmationEvent) -> Unit,
    onConfirmCodeSuccess: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black)
            .padding(start = 15.dp, end = 15.dp, top = 130.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.code_sent_message, uiState.email),
            style = AppTextStyle.title_2
        )

        Text(
            text = stringResource(id = R.string.code_confirm_message),
            style = AppTextStyle.title_3
        )

        OtpInputField(
            value = uiState.code,
            onValueChange = {
                onEvent(
                    EmailConfirmationEvent.UpdateCode(it)
                )
            },
            clearFocus = uiState.codeFilled,
            length = uiState.maxCodeLength,
            modifier = Modifier.focusRequester(focusRequester)
        )

        Button(
            onClick = {
                onEvent(
                    EmailConfirmationEvent.ConfirmCode(onConfirmCodeSuccess)
                )
            },
            enabled = uiState.codeFilled,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColor.blue,
                disabledContainerColor = AppColor.dark_blue
            )
        ) {
            Text(
                text = stringResource(id = R.string.confirm),
                style = AppTextStyle.button_text_1,
                color = if (uiState.codeFilled) AppColor.white else AppColor.grey4
            )
        }

        AnimatedVisibility(
            visible = uiState.loading,
            modifier = Modifier.padding(top = 10.dp),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = AppColor.blue)
            }
        }
    }
}

@Preview
@Composable
private fun EmailVerificationScreenPreview() {
    EmailConfirmationScreen(
        uiState = EmailConfirmationState(email = "example@mail.ru"),
        onEvent = {},
        onConfirmCodeSuccess = {}
    )
}