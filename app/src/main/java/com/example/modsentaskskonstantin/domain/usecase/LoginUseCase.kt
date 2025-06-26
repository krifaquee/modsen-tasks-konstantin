package com.example.modsentaskskonstantin.domain.usecase

<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.exception.AuthException
import com.example.modsentaskskonstantin.domain.repository.IAuthRepository
import kotlin.jvm.Throws

class LoginUseCase (
    private val repository: IAuthRepository
=======
import com.example.modsentaskskonstantin.domain.repository.AuthException
import com.example.modsentaskskonstantin.domain.repository.AuthRepository
import kotlin.jvm.Throws

class LoginUseCase (
    private val repository: AuthRepository
>>>>>>> main
) {
    @Throws(AuthException::class)
    suspend operator fun invoke(login: String, password: String) {
        repository.login(login, password)
    }

}
