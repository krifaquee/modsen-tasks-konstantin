package com.example.modsentaskskonstantin.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel()

) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    // слушатель
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is LoginEvent.ShowError ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()

                LoginEvent.NavigateToHome ->
                    navController.navigate("home") {
                        // убираем экран логина из backstack
                        popUpTo("login") { inclusive = true }
                    }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Контент экрана
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = state.login,
                onValueChange = { viewModel.processIntent(LoginIntent.EnterLogin(it)) },
                label = { Text("Логин") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = state.password,
                onValueChange = { viewModel.processIntent(LoginIntent.EnterPassword(it)) },
                label = { Text("Пароль") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { viewModel.processIntent(LoginIntent.SubmitLogin) },
                enabled = state.isLoginEnabled,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Войти")
            }
        }

        // Индикатор загрузки
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}