package com.lua.login.feature.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lua.desingsystem.component.DefaultButton
import com.lua.desingsystem.component.Header
import com.lua.desingsystem.component.Icon
import com.lua.desingsystem.component.SpacerVertical
import com.lua.desingsystem.component.TextFields
import com.lua.desingsystem.theme.Font
import com.lua.desingsystem.theme.MundoColetorTheme
import com.lua.desingsystem.theme.Size
import com.lua.login.R
import com.lua.login.feature.MainActivity
import com.lua.login.feature.MainViewModel
import com.lua.login.feature.forgot_password.ForgotPasswordViewModel.ScreenEvent
import com.lua.login.feature.forgot_password.ForgotPasswordViewModel.ScreenState
import com.lua.login.feature.util.Router.LOGIN
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController,
    sharedViewModel: MainViewModel,
    viewModel: ForgotPasswordViewModel = getViewModel(),
) {
    Screen(
        screenState = viewModel.screenState.collectAsState(),
        onBackClicked = viewModel::onBackClicked,
        onValueChanged = viewModel::onValueChanged,
        onSendEmailClicked = viewModel::onSendEmailClicked
    )
    EventAction(navController = navController, viewModel = viewModel, sharedViewModel = sharedViewModel)
}

@Composable
fun EventAction(
    navController: NavHostController,
    viewModel: ForgotPasswordViewModel,
    sharedViewModel: MainViewModel
) {
    val activity = LocalContext.current as MainActivity
    LaunchedEffect(key1 = viewModel) {
        viewModel.screenEvent.collect { event ->
            when (event) {
                ScreenEvent.GoBack -> activity.onBackPressed()
                is ScreenEvent.Navigate -> navController.navigate(event.router) {
                    popUpTo(LOGIN) {
                        inclusive = true
                    }
                }
                ScreenEvent.ChangePasswordInShared -> sharedViewModel.changePasswordStatus()
            }
        }
    }
}

@Composable
private fun Screen(
    screenState: State<ScreenState>,
    onValueChanged: (String) -> Unit,
    onBackClicked: () -> Unit,
    onSendEmailClicked: () -> Unit,
) {
    MundoColetorTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            Header(
                title = stringResource(id = R.string.forgot_password_title),
                icon = Icon.icon(
                    iconStart = R.drawable.ic_arrow_back,
                    iconStartDescription = stringResource(id = R.string.forgot_password_title)
                ),
                onStartIconClicked = onBackClicked
            )
            SpacerVertical()
            when (val state = screenState.value) {
                ScreenState.Loading -> TODO()
                is ScreenState.Screen -> ContentScreen(
                    email = state.email,
                    onValueChanged = onValueChanged,
                    onSendEmailClicked = onSendEmailClicked,
                )
            }
        }
    }
}

@Composable
private fun ContentScreen(
    email: MutableStateFlow<String>,
    onValueChanged: (String) -> Unit,
    onSendEmailClicked: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.forgot_password_description),
            style = Font.h1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        SpacerVertical(dp = Size.SizeLG)
        TextFields(
            value = email.collectAsState().value,
            onValueChanged = onValueChanged,
            hint = stringResource(id = R.string.login_email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        SpacerVertical()
        DefaultButton(
            text = stringResource(id = R.string.forgot_password_send_email),
            onClick = onSendEmailClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgotPasswordPreview() {
//    ForgotPasswordScreen(navController = rememberNavController())
}