package com.lua.registerdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lua.desingsystem.component.DefaultButton
import com.lua.desingsystem.theme.MundoColetorTheme
import com.lua.desingsystem.theme.Size
import com.lua.register.feature.RegisterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MundoColetorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultButton(
                        text = "Registro de usuario",
                        onClick = {
                            startActivity(Intent(this, RegisterActivity::class.java))
                        },
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(Size.SizeSM)
                    )
                }
            }
        }
    }
}