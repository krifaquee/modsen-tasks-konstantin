package com.example.modsentaskskonstantin.di

import com.example.modsentaskskonstantin.domain.usecase.GetTasksUseCase
import com.example.modsentaskskonstantin.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetTasksUseCase(get()) }
    factory { LoginUseCase(get()) }
}