package com.example.modsentaskskonstantin.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.modsentaskskonstantin.domain.model.TaskDomainModel
import com.example.modsentaskskonstantin.domain.usecase.GetTasksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {


    private val _tasks = MutableStateFlow<List<TaskDomainModel>>(emptyList())
    val tasks: StateFlow<List<TaskDomainModel>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = getTasksUseCase()
        }
    }
}