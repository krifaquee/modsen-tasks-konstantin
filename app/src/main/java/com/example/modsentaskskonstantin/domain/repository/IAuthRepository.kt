package com.example.modsentaskskonstantin.domain.repository

interface IAuthRepository {
    suspend fun login(login: String, password: String)
}