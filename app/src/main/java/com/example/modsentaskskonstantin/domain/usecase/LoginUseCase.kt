package com.example.modsentaskskonstantin.domain.usecase

import com.example.modsentaskskonstantin.domain.repository.AuthException
import com.example.modsentaskskonstantin.domain.repository.AuthRepository
import kotlin.jvm.Throws

class LoginUseCase (
    private val repository: AuthRepository
) {
    @Throws(AuthException::class)
    suspend operator fun invoke(login: String, password: String) {
        repository.login(login, password)
    }

}
