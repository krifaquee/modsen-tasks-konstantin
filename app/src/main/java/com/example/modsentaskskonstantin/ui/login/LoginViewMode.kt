package com.example.modsentaskskonstantin.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modsentaskskonstantin.domain.exception.AuthException
import com.example.modsentaskskonstantin.domain.usecase.LoginUseCase
import com.example.modsentaskskonstantin.ui.utils.SingleFlowEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _events = SingleFlowEvent<LoginEvent>(viewModelScope)
    val events = _events.flow

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EnterLogin ->
                reduce { copy(login = intent.login) }

            is LoginIntent.EnterPassword ->
                reduce { copy(password = intent.password) }

            LoginIntent.SubmitLogin ->
                performLogin()
        }
    }

    private fun reduce(reducer: LoginState.() -> LoginState) {
        _state.update { old ->
            val updated = old.reducer()
            updated.copy(
                isLoginEnabled = updated.login.isNotBlank()
                        && updated.password.isNotBlank()
                        && !updated.isLoading
            )
        }
    }

    private fun performLogin() = viewModelScope.launch {
        reduce { copy(isLoading = true) }
        try {
            loginUseCase(state.value.login, state.value.password)
            _events.emit(LoginEvent.NavigateToHome)
        } catch (e: AuthException) {
            _events.emit(LoginEvent.ShowError(e.message ?: "Ошибка входа"))
        } finally {
            reduce { copy(isLoading = false) }
        }
    }
}