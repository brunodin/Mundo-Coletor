package com.lua.desingsystem.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.lua.desingsystem.theme.DsColor.DefaultWhite
import com.lua.desingsystem.theme.DsColor.Primary100
import com.lua.desingsystem.theme.DsColor.Primary200
import com.lua.desingsystem.theme.DsColor.Secondary100

private val LightColorPalette = lightColors(
    primary = Primary100,
    primaryVariant = Primary200,
    secondary = Secondary100,
    background = DefaultWhite
)

@Composable
fun MundoColetorTheme(
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = Font,
        content = content
    )
}