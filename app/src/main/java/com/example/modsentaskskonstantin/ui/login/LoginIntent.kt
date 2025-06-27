package com.example.modsentaskskonstantin.ui.login

sealed class LoginIntent {
    data class EnterLogin(val login: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    object SubmitLogin : LoginIntent()
}
