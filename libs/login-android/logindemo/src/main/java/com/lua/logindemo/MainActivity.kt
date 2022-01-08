package com.lua.logindemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.lua.desingsystem.component.DefaultButton
import com.lua.desingsystem.theme.Size
import com.lua.login.feature.MainActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultButton(
                text = "Login",
                onClick = {
                    startActivity(Intent(this, MainActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Size.SizeSM)
            )
        }
    }
}