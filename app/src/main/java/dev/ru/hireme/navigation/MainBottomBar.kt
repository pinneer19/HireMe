package dev.ru.hireme.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun MainBottomBar(
    currentRoute: String,
    onNavigationBarItemClick: (Route) -> Unit
) {
    NavigationBar(
        containerColor = AppColor.black
    ) {
        BottomNavigation.entries.forEach { navigationItem ->
            val isSelected by remember(currentRoute) {
                derivedStateOf { currentRoute == navigationItem.route::class.qualifiedName }
            }

            val label = stringResource(id = navigationItem.labelResId)

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColor.blue,
                    indicatorColor = AppColor.transparent,
                    unselectedIconColor = AppColor.grey4
                ),
                selected = isSelected,
                label = {
                    Text(
                        text = label,
                        style = AppTextStyle.tab_text,
                        color = if (isSelected) AppColor.blue else AppColor.grey4
                    )
                },
                onClick = {
                    onNavigationBarItemClick(navigationItem.route)
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = navigationItem.iconResId),
                        contentDescription = label
                    )
                }
            )
        }
    }
}