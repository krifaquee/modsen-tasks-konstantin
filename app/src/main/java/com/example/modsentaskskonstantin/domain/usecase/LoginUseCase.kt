package com.example.modsentaskskonstantin.domain.usecase


import com.example.modsentaskskonstantin.domain.exception.AuthException
import com.example.modsentaskskonstantin.domain.repository.IAuthRepository
import kotlin.jvm.Throws

class LoginUseCase (
    private val repository: IAuthRepository

) {
    @Throws(AuthException::class)
    suspend operator fun invoke(login: String, password: String) {
        repository.login(login, password)
    }

}
