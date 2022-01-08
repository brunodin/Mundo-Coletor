package com.lua.login.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lua.login.feature.forgot_password.ForgotPasswordScreen
import com.lua.login.feature.login.LoginScreen
import com.lua.login.feature.util.Router.FORGOT_PASSWORD
import com.lua.login.feature.util.Router.LOGIN
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = LOGIN) {
                composable(LOGIN) {
                    LoginScreen(navController = navController, sharedViewModel = viewModel)
                }
                composable(FORGOT_PASSWORD) {
                    ForgotPasswordScreen(navController = navController, sharedViewModel = viewModel)
                }
            }
        }
    }
}