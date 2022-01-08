package com.lua.desingsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.lua.desingsystem.theme.DsColor.Support300
import com.lua.desingsystem.theme.Size

@Composable
fun CardColumn(
    background: Color,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        elevation = Size.Size0,
        backgroundColor = background,
        shape = RectangleShape,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(all = Size.SizeSM)) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlertWarningPreview() {
    CardColumn(Support300) {}
}