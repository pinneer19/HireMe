package dev.ru.hireme.ui.screen.email_confirmation.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor

@Composable
fun OtpFieldItem(
    value: Char?,
    isFocused: Boolean,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Otp item infinite transition")

    val cursorAlpha by infiniteTransition.animateFloat(
        initialValue = if (isFocused) 1f else 0f,
        targetValue = if (isFocused) 0f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Otp item cursor alpha animation"
    )

    Box(
        modifier = modifier
            .size(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(AppColor.grey2),
        contentAlignment = Alignment.Center,
    ) {
        if (!isFocused) {
            value?.let {
                Text(
                    text = it.toString(),
                    color = AppColor.grey3,
                )
            } ?: Icon(
                imageVector = Icons.Default.Emergency,
                tint = AppColor.grey3,
                modifier = Modifier.size(12.dp),
                contentDescription = stringResource(R.string.code_text_placeholder)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .width(2.dp)
                .height(24.dp)
                .alpha(cursorAlpha)
                .background(AppColor.white)
        )
    }
}