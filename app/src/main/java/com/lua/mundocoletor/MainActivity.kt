package com.lua.mundocoletor

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lua.desingsystem.component.Header
import com.lua.mundocoletor.ui.theme.MundoColetorTheme
import com.lua.register.feature.RegisterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MundoColetorTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    Header()
    val activity = LocalContext.current as MainActivity
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MundoColetorTheme {
        Greeting("Android")
    }
}