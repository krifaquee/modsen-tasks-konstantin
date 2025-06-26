package com.example.modsentaskskonstantin.di

import com.example.modsentaskskonstantin.data.TaskRepositoryImpl
import com.example.modsentaskskonstantin.data.auth.AuthRepositoryImpl
<<<<<<< task-1-1
import com.example.modsentaskskonstantin.data.repository.PostRepositoryImpl
import com.example.modsentaskskonstantin.domain.repository.IAuthRepository
import com.example.modsentaskskonstantin.domain.repository.IPostRepository
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<ITaskRepository> { TaskRepositoryImpl() }
    single<IAuthRepository> { AuthRepositoryImpl() }
    single<IPostRepository> { PostRepositoryImpl(get()) }
=======
import com.example.modsentaskskonstantin.domain.repository.AuthRepository
import com.example.modsentaskskonstantin.domain.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<TaskRepository> {TaskRepositoryImpl()}
    single<AuthRepository> { AuthRepositoryImpl()}
>>>>>>> main
}