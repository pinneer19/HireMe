package dev.ru.hireme.ui.util

import kotlinx.datetime.LocalDate

fun String.toDate(): LocalDate = LocalDate.parse(this)