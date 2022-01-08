package com.lua.register.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lua.register.feature.register_credentials.RegisterCredentialsScreen
import com.lua.register.feature.util.Router
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : ComponentActivity() {

    val viewModel : RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Router.REGISTER_CREDENTIALS) {
                composable(Router.REGISTER_CREDENTIALS) {
                    RegisterCredentialsScreen(navController = navController, sharedViewModel = viewModel)
                }
            }
        }
    }
}