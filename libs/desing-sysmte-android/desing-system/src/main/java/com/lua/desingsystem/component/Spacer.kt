package com.lua.desingsystem.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.lua.desingsystem.theme.Size

@Composable
fun SpacerVertical(dp: Dp = Size.SizeSM) {
    Spacer(modifier = Modifier.height(dp))
}

@Composable
fun SpacerHorizontal(dp: Dp = Size.SizeSM) {
    Spacer(modifier = Modifier.width(dp))
}