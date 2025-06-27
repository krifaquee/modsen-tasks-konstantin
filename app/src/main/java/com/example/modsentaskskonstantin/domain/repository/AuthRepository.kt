package com.example.modsentaskskonstantin.domain.repository

interface AuthRepository {
    suspend fun login(login: String, password: String)
}

class AuthException(message: String) : Exception(message)