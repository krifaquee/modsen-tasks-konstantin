package com.example.modsentaskskonstantin.di


import com.example.modsentaskskonstantin.ui.login.LoginViewModel
<<<<<<< task-1-1
import com.example.modsentaskskonstantin.ui.posts.PostViewModel

=======
>>>>>>> main
import com.example.modsentaskskonstantin.ui.tasks.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel {
        TaskListViewModel(get())
    }
<<<<<<< task-1-1
    viewModel { PostViewModel(get()) }
=======
>>>>>>> main
}