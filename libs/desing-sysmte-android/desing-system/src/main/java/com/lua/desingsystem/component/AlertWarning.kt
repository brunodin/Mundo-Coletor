package com.lua.desingsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.lua.core.EMPTY_STRING
import com.lua.desingsystem.theme.DsColor.DefaultBlack
import com.lua.desingsystem.theme.DsColor.Support500
import com.lua.desingsystem.theme.Font
import com.lua.desingsystem.theme.Size
import com.lua.desingsystem.theme.h3Bold

@Composable
fun AlertWarning(
    title: String = EMPTY_STRING,
    description: String = EMPTY_STRING,
    visible: Boolean = true
) {
    if (visible) {
        CardColumn(
            background = Support500
        ) {
            Column {
                if (title.isNotEmpty()) {
                    Text(
                        text = title,
                        style = Font.h3Bold,
                        color = DefaultBlack
                    )
                }
                SpacerVertical(dp = Size.SizeXSM)
                if (description.isNotEmpty()) {
                    Text(
                        text = description,
                        style = Font.h3,
                        color = DefaultBlack
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlertWarningPreview() {
    AlertWarning("teste", "esse é um teste")
}