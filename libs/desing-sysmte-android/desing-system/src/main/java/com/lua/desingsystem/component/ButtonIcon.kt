package com.lua.desingsystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.lua.desingsystem.theme.DsColor.DefaultBlack
import com.lua.desingsystem.theme.Size.SizeMD

@Composable
fun ButtonIcon(
    icon: Painter,
    description: String,
    onClick: () -> Unit,
    buttonColor: Color = DefaultBlack,
    iconSize: Dp = SizeMD
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            painter = icon,
            contentDescription = description,
            modifier = Modifier.size(size = iconSize),
            tint = buttonColor,
        )
    }
}