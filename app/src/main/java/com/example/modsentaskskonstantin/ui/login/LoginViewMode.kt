package com.example.modsentaskskonstantin.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.exception.AuthException
import com.example.modsentaskskonstantin.domain.usecase.LoginUseCase
import com.example.modsentaskskonstantin.ui.utils.SingleFlowEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
=======
import com.example.modsentaskskonstantin.domain.repository.AuthException
import com.example.modsentaskskonstantin.domain.usecase.LoginUseCase
import com.example.modsentaskskonstantin.ui.utils.SingleFlowEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
>>>>>>> main
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

<<<<<<< task-1-1
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

=======
    private val _intents = MutableSharedFlow<LoginIntent>(extraBufferCapacity = 1)
    val intents: SharedFlow<LoginIntent> = _intents.asSharedFlow()

    private val _events = SingleFlowEvent<LoginEvent>(viewModelScope)
    val events = _events.flow

    init {
        viewModelScope.launch {
            intents.collect { intent ->
                when (intent) {
                    is LoginIntent.EnterLogin ->
                        reduceState { copy(login = intent.login) }
                    is LoginIntent.EnterPassword ->
                        reduceState { copy(password = intent.password) }
                    is LoginIntent.SubmitLogin ->
                        handleSubmit()
                }
            }
        }
    }

    private fun reduceState(reducer: LoginState.() -> LoginState) {
        _state.update(reducer)
        val s = _state.value
        _state.update {
            it.copy(
                isLoginEnabled = s.login.isNotBlank()
                        && s.password.isNotBlank()
                        && !s.isLoading
            )
        }
    }

    private suspend fun handleSubmit() {
        _state.update { it.copy(isLoading = true, isLoginEnabled = false) }
>>>>>>> main
        try {
            loginUseCase(state.value.login, state.value.password)
            _events.emit(LoginEvent.NavigateToHome)
        } catch (e: AuthException) {
            _events.emit(LoginEvent.ShowError(e.message ?: "Ошибка входа"))
        } finally {
<<<<<<< task-1-1
            reduce { copy(isLoading = false) }
        }
    }
}
=======
            _state.update {
                it.copy(
                    isLoading = false,
                    isLoginEnabled =
                    it.login.isNotBlank() && it.password.isNotBlank()
                )
            }
        }
    }

    // Внешний API: отправка Intents
    fun processIntent(intent: LoginIntent) {
        viewModelScope.launch { _intents.emit(intent) }
    }
}
>>>>>>> main
