package com.example.modsentaskskonstantin.di


import com.example.modsentaskskonstantin.ui.login.LoginViewModel
import com.example.modsentaskskonstantin.ui.tasks.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel {
        TaskListViewModel(get())
    }
}