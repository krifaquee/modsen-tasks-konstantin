package com.example.modsentaskskonstantin.di

<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.usecase.GetPostsUseCase
=======
>>>>>>> main
import com.example.modsentaskskonstantin.domain.usecase.GetTasksUseCase
import com.example.modsentaskskonstantin.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetTasksUseCase(get()) }
    factory { LoginUseCase(get()) }
<<<<<<< task-1-1
    factory { GetPostsUseCase(get()) }
=======
>>>>>>> main
}