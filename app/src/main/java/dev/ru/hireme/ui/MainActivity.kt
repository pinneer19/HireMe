package dev.ru.hireme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.ru.hireme.navigation.HireMeGraph
import dev.ru.hireme.ui.theme.AppColor
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // For correct text displaying on english layout devices
        this.resources.configuration.setLocale(Locale("ru"))
        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(scrim = AppColor.black.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(scrim = AppColor.black.toArgb())
        )

        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                HireMeGraph()
            }
        }
    }
}