package com.example.modsentaskskonstantin.data.auth

<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.exception.AuthException
import com.example.modsentaskskonstantin.domain.repository.IAuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl : IAuthRepository {
=======
import com.example.modsentaskskonstantin.domain.repository.AuthException
import com.example.modsentaskskonstantin.domain.repository.AuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl : AuthRepository {
>>>>>>> main
    private val validCredentials = listOf(
        "user1" to "password1",
        "user2" to  "password2"
    )

    override suspend fun login(login: String, password: String) {
        delay(700)

        // проверка комбинации
        if (validCredentials.none { it.first == login && it.second == password }){
            throw AuthException("Неверный логин или пароль")
        }
    }
}