package com.lua.login.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.lua.core.WEIGHT1F
import com.lua.core.rememberAlertWarningVisibility
import com.lua.desingsystem.component.AlertWarning
import com.lua.desingsystem.component.ButtonStyle
import com.lua.desingsystem.component.ButtonWidth
import com.lua.desingsystem.component.DefaultButton
import com.lua.desingsystem.component.Header
import com.lua.desingsystem.component.Icon
import com.lua.desingsystem.component.SpacerVertical
import com.lua.desingsystem.component.TextFieldPassword
import com.lua.desingsystem.component.TextFields
import com.lua.desingsystem.theme.Font
import com.lua.desingsystem.theme.MundoColetorTheme
import com.lua.desingsystem.theme.Size
import com.lua.login.R
import com.lua.login.feature.MainActivity
import com.lua.login.feature.MainViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navController: NavHostController,
    sharedViewModel: MainViewModel,
    viewModel: LoginViewModel = getViewModel(),
) {
    Screen(
        screenState = viewModel.screenState.collectAsState(),
        onSingUpClicked = viewModel::onSingUpClicked,
        onBackClicked = viewModel::onBackClicked,
        onSingInClicked = viewModel::onSingInClicked,
        onValueChanged = viewModel::onValueChanged,
        onForgotPasswordClicked = viewModel::onForgotPasswordClicked,
        isPasswordChanged = sharedViewModel.hasPasswordChanged.collectAsState()
    )
    EventAction(navController = navController, viewModel = viewModel)
}

@Composable
fun EventAction(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val activity = LocalContext.current as MainActivity
    LaunchedEffect(key1 = viewModel) {
        viewModel.screenEvent.collect { event ->
            when (event) {
                ScreenEvent.Finish -> activity.finish()
                ScreenEvent.GoBack -> activity.onBackPressed()
                is ScreenEvent.Navigate -> navController.navigate(event.router)
            }
        }
    }
}

@Composable
private fun Screen(
    screenState: State<ScreenState>,
    onValueChanged: (TextFieldType) -> Unit,
    onBackClicked: () -> Unit,
    onSingInClicked: () -> Unit,
    onSingUpClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit,
    isPasswordChanged: State<Boolean>,
) {
    MundoColetorTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            Header(
                icon = Icon.icon(
                    iconStart = R.drawable.ic_arrow_back,
                    iconStartDescription = stringResource(id = R.string.login_back_description)
                ),
                onStartIconClicked = onBackClicked
            )
            SpacerVertical()
            when (val state = screenState.value) {
                ScreenState.Loading -> TODO()
                is ScreenState.Screen -> ContentScreen(
                    textFieldValues = state.textFieldValues,
                    onValueChanged = onValueChanged,
                    onSingInClicked = onSingInClicked,
                    onSingUpClicked = onSingUpClicked,
                    onForgotPasswordClicked = onForgotPasswordClicked,
                    isPasswordChanged = isPasswordChanged
                )
            }
        }
    }
}

@Composable
private fun ContentScreen(
    textFieldValues: TextFieldValues,
    onValueChanged: (TextFieldType) -> Unit,
    onSingInClicked: () -> Unit,
    onSingUpClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit,
    isPasswordChanged: State<Boolean>,
) {
    Column {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(height = Size.Size10XLG, width = Size.Size10XLG)
                .align(Alignment.CenterHorizontally),
        )
        Text(
            text = stringResource(id = R.string.login_welcome),
            style = Font.h1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpacerVertical(dp = Size.Size3XLG)
        TextFields(
            value = textFieldValues.email.collectAsState().value.text,
            onValueChanged = { onValueChanged(TextFieldType.Email(it)) },
            hint = stringResource(id = R.string.login_email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        SpacerVertical()
        TextFieldPassword(
            value = textFieldValues.password.collectAsState().value.text,
            onValueChanged = { onValueChanged(TextFieldType.Password(it)) },
            hint = stringResource(id = R.string.login_password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        LoginTextButton(onClick = onForgotPasswordClicked)
        SpacerVertical(dp = Size.SizeLG)
        DefaultButton(
            text = stringResource(id = R.string.login_sing_in),
            onClick = onSingInClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        SpacerVertical()
        DefaultButton(
            text = stringResource(id = R.string.login_sing_up),
            onClick = onSingUpClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Size.SizeSM)
        )
        Spacer(modifier = Modifier.weight(WEIGHT1F))
        val rememberAlertVisibility = rememberAlertWarningVisibility()
        if (isPasswordChanged.value) {
            AlertWarning(
                stringResource(id = R.string.login_password_changed),
                stringResource(id = R.string.login_password_change_description),
                visible = rememberAlertVisibility.passwordVisibility.value
            )
        }
    }
}

@Composable
private fun ColumnScope.LoginTextButton(onClick: () -> Unit) {
    DefaultButton(
        text = stringResource(id = R.string.login_forgot_password),
        textStyle = Font.h2,
        onClick = onClick,
        buttonStyle = ButtonStyle.text(),
        buttonWidth = ButtonWidth.wrapContent(),
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = Size.SizeSM)
            .align(alignment = Alignment.End)
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
//    LoginScreen(navController = rememberNavController())
}