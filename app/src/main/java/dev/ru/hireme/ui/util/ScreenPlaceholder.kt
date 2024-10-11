package dev.ru.hireme.ui.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.ru.hireme.ui.theme.AppColor

@Composable
fun ScreenPlaceholder(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.black),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title)
    }
}