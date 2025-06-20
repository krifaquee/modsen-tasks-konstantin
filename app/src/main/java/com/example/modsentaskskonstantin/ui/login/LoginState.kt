package com.example.modsentaskskonstantin.ui.login

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)
