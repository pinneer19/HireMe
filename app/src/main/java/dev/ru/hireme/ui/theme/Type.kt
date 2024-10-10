package dev.ru.hireme.ui.theme


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import dev.ru.hireme.R

object AppTextStyle {
    val title_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 30.8.sp,
        color = Color.White
    )

    val title_2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 28.sp,
        color = Color.White
    )

    val title_3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 22.4.sp,
        color = Color.White
    )

    val title_4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 19.6.sp,
        color = Color.White
    )

    val text_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 19.6.sp,
        color = Color.White
    )

    val button_text_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 22.4.sp,
        color = Color.White
    )

    val button_text_2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 16.sp,
        color = Color.White
    )

    val tab_text = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 14.sp
    )

    val number = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 9.8.sp,
        color = Color.White
    )
}