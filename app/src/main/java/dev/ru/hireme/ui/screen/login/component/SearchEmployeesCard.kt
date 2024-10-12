package dev.ru.hireme.ui.screen.login.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun SearchEmployeesCard(modifier: Modifier = Modifier) {

    val context = LocalContext.current

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