package dev.ru.hireme.ui.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PinDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ru.domain.model.Offer
import dev.ru.hireme.R
import dev.ru.hireme.ui.theme.AppColor
import dev.ru.hireme.ui.theme.AppTextStyle

@Composable
fun OfferCard(offer: Offer, modifier: Modifier = Modifier) {

    val iconResId: ImageVector? = when (offer.id) {
        "near_vacancies" -> Icons.Outlined.PinDrop
        "level_up_resume" -> ImageVector.vectorResource(id = R.drawable.ic_star)
        "temporary_job" -> ImageVector.vectorResource(id = R.drawable.ic_temporary_job)
        else -> null
    }

    val iconColor: Pair<Color, Color> =
        if (offer.id == "near_vacancies") AppColor.dark_blue to AppColor.blue
        else AppColor.dark_green to AppColor.green

    val uriHandler = LocalUriHandler.current

    Card(
        onClick = { uriHandler.openUri(offer.link) },
        modifier = modifier
            .size(width = 160.dp, height = 145.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = AppColor.grey1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 12.dp, top = 10.dp, bottom = 11.dp),
            verticalArrangement = Arrangement.Center
        ) {
            iconResId?.let { icon ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(iconColor.first)
                        .padding(6.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        tint = iconColor.second,
                        contentDescription = stringResource(id = R.string.offer_icon)
                    )
                }
            }

            Text(
                text = offer.title.trimStart(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                maxLines = if (offer.text == null) 3 else 2,
                overflow = TextOverflow.Ellipsis
            )

            offer.text?.let {
                Text(
                    text = it,
                    style = AppTextStyle.text_1,
                    color = AppColor.green
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OfferCardPreview() {
    OfferCard(
        offer = Offer(
            id = "near_vacancies",
            link = "",
            title = "Поднять резюме в поиске",
            text = "Поднять"
        )
    )
}