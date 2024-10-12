package dev.ru.hireme.ui.screen.vacancy_details.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun ApplicationContent(
    title: String,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onExpand: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .background(AppColor.black)
            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            color = AppColor.grey2,
            modifier = Modifier
                .width(38.dp)
                .padding(vertical = 24.dp)
                .clip(RoundedCornerShape(10.dp)),
            thickness = 5.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_avatar),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(
                    id = R.string.avatar_image
                ),
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = stringResource(R.string.application_resume),
                    style = AppTextStyle.text_1,
                    color = AppColor.grey3,
                )

                Text(
                    text = title,
                    style = AppTextStyle.title_3
                )
            }
        }

        HorizontalDivider(
            color = AppColor.grey2,
            modifier = Modifier.padding(top = 24.dp)
        )

        if (!expanded) {
            TextButton(onClick = onExpand) {
                Text(
                    text = stringResource(R.string.add_cover_letter),
                    style = AppTextStyle.button_text_1.copy(fontSize = 18.sp),
                    color = AppColor.green,
                    modifier = Modifier.padding(top = 40.dp)
                )
            }
        } else {
            TextField(
                value = "",
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = AppColor.transparent,
                    unfocusedContainerColor = AppColor.transparent,
                    focusedIndicatorColor = AppColor.transparent,
                    unfocusedIndicatorColor = AppColor.transparent
                ),
                placeholder = {
                    Text(
                        text = stringResource(R.string.your_cover_letter),
                        color = AppColor.grey3
                    )
                },
                textStyle = AppTextStyle.text_1,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 85.dp)
                    .padding(top = 16.dp),
            )
        }

        Button(
            onClick = {},
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = AppColor.green
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .height(56.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.apply),
                style = AppTextStyle.button_text_2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApplicationContentPreview() {
    ApplicationContent(
        title = "UI/UX designer",
        expanded = true
    )
}