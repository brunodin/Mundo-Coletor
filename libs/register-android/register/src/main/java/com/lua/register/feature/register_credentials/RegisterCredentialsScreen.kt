package com.lua.register.feature.register_credentials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.lua.desingsystem.component.DefaultButton
import com.lua.desingsystem.component.Header
import com.lua.desingsystem.component.Icon
import com.lua.desingsystem.component.Progress
import com.lua.desingsystem.component.SpacerVertical
import com.lua.desingsystem.theme.MundoColetorTheme
import com.lua.register.R
import com.lua.register.feature.RegisterActivity
import com.lua.register.feature.RegisterViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterCredentialsScreen(
    navController: NavHostController,
    sharedViewModel: RegisterViewModel,
    viewModel: RegisterCredentialsViewModel = getViewModel(),
) {
    Screen(
        onBackClicked = viewModel::onBackClicked,
        onCloseClicked = viewModel::onCloseClicked,
    )
    EventAction(navController = navController, viewModel = viewModel)
}

@Composable
fun EventAction(
    navController: NavHostController,
    viewModel: RegisterCredentialsViewModel
) {
    val activity = LocalContext.current as RegisterActivity
    LaunchedEffect(key1 = viewModel) {
        viewModel.screenEvent.collect { event ->
            when (event) {
                else -> {}
            }
        }
    }
}

@Composable
private fun Screen(
    onBackClicked: () -> Unit,
    onCloseClicked: () -> Unit,
) {
    MundoColetorTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Header(
                icon = Icon.icon(
                    iconStart = R.drawable.ic_arrow_back,
                    iconEnd = R.drawable.ic_close,
                ),
                title = stringResource(R.string.register_new_register),
                onStartIconClicked = onBackClicked,
                onEndIconClicked = onCloseClicked,
            )
            SpacerVertical()
            val progress = remember { mutableStateOf(0f) }
            Progress(progress.value)
            DefaultButton(text = "Tes", onClick = { progress.value = 1f })
        }
    }
}