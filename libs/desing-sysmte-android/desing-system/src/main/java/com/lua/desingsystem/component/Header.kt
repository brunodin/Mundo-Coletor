package com.lua.desingsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.lua.core.EMPTY_STRING
import com.lua.desingsystem.R
import com.lua.desingsystem.theme.DsColor
import com.lua.desingsystem.theme.DsColor.DefaultBlack
import com.lua.desingsystem.theme.Font
import com.lua.desingsystem.theme.Size.Size0
import com.lua.desingsystem.theme.h1Bold

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    titleColor: Color = DefaultBlack,
    background: Color = DsColor.DefaultWhite,
    icon: Icon = Icon.icon(),
    elevation: Dp = Size0,
    isCapslockOn: Boolean = true,
    onStartIconClicked: () -> Unit = {},
    onEndIconClicked: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        elevation = elevation,
        backgroundColor = background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon.startIcon?.let {
                ButtonIcon(
                    icon = painterResource(id = icon.startIcon),
                    description = icon.iconStartDescription,
                    buttonColor = icon.colorIcon,
                    onClick = onStartIconClicked
                )
            }
            SpacerHorizontal()
            Text(
                modifier = Modifier.weight(1f),
                text = if (isCapslockOn) title.uppercase() else title,
                style = Font.h1Bold,
                color = titleColor,
            )
            SpacerHorizontal()
            icon.endIcon?.let {
                ButtonIcon(
                    icon = painterResource(id = icon.endIcon),
                    description = icon.iconEndDescription,
                    buttonColor = icon.colorIcon,
                    onClick = onEndIconClicked
                )
            }
        }
    }
}

data class Icon(
    val startIcon: Int?,
    val endIcon: Int?,
    val colorIcon: Color,
    val iconStartDescription: String,
    val iconEndDescription: String,
) {
    companion object {
        @Composable
        fun icon(
            iconStart: Int? = null,
            iconStartDescription: String = EMPTY_STRING,
            iconEnd: Int? = null,
            iconEndDescription: String = EMPTY_STRING,
            iconColor: Color = DefaultBlack
        ) = Icon(
            startIcon = iconStart,
            endIcon = iconEnd,
            colorIcon = iconColor,
            iconStartDescription = iconStartDescription,
            iconEndDescription = iconEndDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header(title = "Teste", icon = Icon.icon(iconStart = R.drawable.ic_arrow_back))
}
