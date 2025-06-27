package com.example.modsentaskskonstantin.ui.login

sealed class LoginEvent {
    data class ShowError(val message: String) : LoginEvent()
    object NavigateToHome : LoginEvent()
}