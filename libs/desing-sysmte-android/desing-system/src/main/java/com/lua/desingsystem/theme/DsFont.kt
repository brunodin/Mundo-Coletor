package com.lua.desingsystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val Font = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.LG
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.MD
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.SM
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.XSM
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = DsFontSize.MD
    )
)

inline val Typography.h1Bold get() = h1.copy(fontWeight = FontWeight.Bold)
inline val Typography.h2Bold get() = h2.copy(fontWeight = FontWeight.Bold)
inline val Typography.h3Bold get() = h3.copy(fontWeight = FontWeight.Bold)
inline val Typography.h4Bold get() = h4.copy(fontWeight = FontWeight.Bold)