package com.lua.desingsystem.component

import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.lua.desingsystem.theme.DsColor
import com.lua.desingsystem.theme.Line
import com.lua.desingsystem.theme.Size

@Composable
fun Progress(
    progress: Float,
    modifier: Modifier = Modifier,
    height: Dp = Size.SizeSM,
) {
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    LinearProgressIndicator(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .padding(horizontal = Size.SizeSM)
            .background(color = DsColor.DefaultWhite, shape = RoundedCornerShape(Size.SizeXSM))
            .border(width = Line.LineMD, color = DsColor.DefaultBlack),
        color = DsColor.Support200,
        backgroundColor = DsColor.DefaultWhite,
        progress = animatedProgress.value
    )
}