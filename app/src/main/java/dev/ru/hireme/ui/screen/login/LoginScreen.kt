package dev.ru.hireme.ui.screen.login

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.screen.login.component.SearchEmployeesCard
import dev.ru.hireme.ui.screen.login.component.SearchJobCard
import dev.ru.hireme.ui.screen.login.viewmodel.LoginEvent
import dev.ru.hireme.ui.screen.login.viewmodel.LoginState
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun LoginScreen(
    uiState: LoginState,
    onEvent: (LoginEvent) -> Unit,
    onConfirmEmail: () -> Unit
) {
    val context = LocalContext.current
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
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.login_to_account),
            style = AppTextStyle.title_2,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(top = 32.dp)
        )

        Spacer(modifier = Modifier.height(144.dp))

        SearchJobCard(
            email = uiState.email,
            onEmailUpdate = {
                onEvent(LoginEvent.UpdateEmailInput(it))
            },
            onLogin = {
                onEvent(LoginEvent.Login(onConfirmEmail = onConfirmEmail))
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        SearchEmployeesCard(modifier = Modifier.fillMaxWidth())

        AnimatedVisibility(
            visible = uiState.loading,
            modifier = Modifier.padding(top = 10.dp),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator(color = AppColor.blue)
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