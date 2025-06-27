package com.example.modsentaskskonstantin.di

import com.example.modsentaskskonstantin.data.repository.TaskRepositoryImpl
import com.example.modsentaskskonstantin.data.auth.AuthRepositoryImpl
import com.example.modsentaskskonstantin.data.repository.PostRepositoryImpl
import com.example.modsentaskskonstantin.domain.repository.IAuthRepository
import com.example.modsentaskskonstantin.domain.repository.IPostRepository
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<ITaskRepository> { TaskRepositoryImpl() }
    single<IAuthRepository> { AuthRepositoryImpl() }
    single<IPostRepository> { PostRepositoryImpl(get()) }

}