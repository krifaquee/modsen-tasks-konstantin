package com.example.modsentaskskonstantin.di

import com.example.modsentaskskonstantin.data.TaskRepositoryImpl
import com.example.modsentaskskonstantin.data.auth.AuthRepositoryImpl
import com.example.modsentaskskonstantin.domain.repository.AuthRepository
import com.example.modsentaskskonstantin.domain.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<TaskRepository> {TaskRepositoryImpl()}
    single<AuthRepository> { AuthRepositoryImpl()}
}