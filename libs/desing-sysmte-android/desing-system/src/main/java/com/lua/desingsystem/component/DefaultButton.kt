package com.lua.desingsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.lua.desingsystem.theme.DsColor
import com.lua.desingsystem.theme.Font
import com.lua.desingsystem.theme.Line
import com.lua.desingsystem.theme.Size

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = Font.button,
    isEnable: Boolean = true,
    buttonStyle: ButtonStyle = ButtonStyle.outline(),
    buttonHeight: Dp = Size.SizeLG,
    icon: Icon = Icon.icon(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    buttonWidth: ButtonWidth = ButtonWidth.fill(),
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height = buttonHeight),
        enabled = isEnable,
        shape = buttonStyle.shape,
        elevation = ButtonDefaults.elevation(
            defaultElevation = buttonStyle.elevation,
            disabledElevation = Size.Size0,
            pressedElevation = Size.Size0
        ),
        border = buttonStyle.stroke?.let { stroke ->
            BorderStroke(width = stroke.width, color = stroke.color)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonStyle.color),
    ) {
        Row(
            modifier = buttonWidth.width,
            horizontalArrangement = horizontalArrangement
        ) {
            icon.startIcon?.let { startIcon ->
                ButtonIcon(
                    description = icon.iconStartDescription,
                    startIcon = startIcon,
                )
                SpacerHorizontal()
            }
            Text(
                text = if (buttonStyle.isCapslockActive) text.uppercase() else text,
                style = textStyle,
                textAlign = TextAlign.Center
            )
            icon.endIcon?.let { endIcon ->
                SpacerHorizontal()
                ButtonIcon(
                    description = icon.iconStartDescription,
                    startIcon = endIcon,
                )
            }
        }
    }
}

@Composable
private fun ButtonIcon(startIcon: Int, description: String) {
    Icon(
        painter = painterResource(id = startIcon),
        contentDescription = description,
        modifier = Modifier.size(size = Size.SizeMD),
    )
}

data class ButtonWidth(
    val width: Modifier,
) {
    companion object {
        @Composable
        fun fill() = ButtonWidth(Modifier.fillMaxWidth())
        @Composable
        fun wrapContent() = ButtonWidth(Modifier.wrapContentSize())
    }
}

data class ButtonStyle(
    val color: Color,
    val stroke: Stroke?,
    val elevation: Dp,
    val shape: Shape,
    val isCapslockActive: Boolean,
) {
    companion object {
        @Composable
        fun outline() = ButtonStyle(
            color = DsColor.DefaultWhite,
            stroke = Stroke(width = Line.LineMD, color = DsColor.Support200),
            elevation = Size.Size0,
            shape = MaterialTheme.shapes.medium,
            isCapslockActive = true
        )

        @Composable
        fun text() = outline().copy(stroke = null, isCapslockActive = false)
    }
}

data class Stroke(
    val width: Dp,
    val color: Color,
)

@Preview(showBackground = true)
@Composable
private fun ButtonPreview() {
    DefaultButton("", {})
}