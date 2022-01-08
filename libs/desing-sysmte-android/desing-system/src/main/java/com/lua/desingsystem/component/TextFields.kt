package com.lua.desingsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.lua.core.EMPTY_STRING
import com.lua.desingsystem.theme.DsColor
import com.lua.desingsystem.theme.Font

private const val ONE_LINE = 1

@Composable
fun TextFields(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    isReadOnly: Boolean = false,
    style: TextStyle = Font.h2,
    hint: String = EMPTY_STRING,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxLines: Int = Int.MAX_VALUE,
    onFocusChanged: (Boolean) -> Unit = {}
) {
    val interaction = remember { MutableInteractionSource() }
    val focus = interaction.collectIsFocusedAsState()
    onFocusChanged(focus.value)
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier,
        enabled = isEnable,
        readOnly = isReadOnly,
        textStyle = style,
        label = { Text(text = hint, style = Font.h2, color = DsColor.Support200) },
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = false,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = maxLines == ONE_LINE,
        maxLines = maxLines,
        interactionSource = interaction,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextPreview() {
    TextFields("", {})
}