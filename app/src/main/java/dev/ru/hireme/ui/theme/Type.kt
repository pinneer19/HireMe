package dev.ru.hireme.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import dev.ru.hireme.R

object AppTextStyle {
    val title_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 28.6.sp,
        color = AppColor.white
    )

    val title_2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 26.sp,
        color = AppColor.white
    )

    val title_3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 20.8.sp,
        color = AppColor.white
    )

    val title_4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 18.2.sp,
        color = AppColor.white
    )

    val text_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 18.2.sp,
        color = AppColor.white
    )

    val button_text_1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontSize = 20.8.sp,
        color = AppColor.white
    )

    val button_text_2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 18.2.sp,
        color = AppColor.white
    )

    val tab_text = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 12.5.sp,
        color = AppColor.grey4
    )

    val number = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 9.1.sp,
        color = AppColor.white
    )
}