package com.example.modsentaskskonstantin.data

import com.example.modsentaskskonstantin.domain.model.Task
import com.example.modsentaskskonstantin.domain.repository.TaskRepository
import kotlinx.coroutines.delay

class TaskRepositoryImpl : TaskRepository {
    override suspend fun getAllTasks(): List<Task> {
        delay(500)
        return listOf(
            Task(id = "1", title = "Задание №1")
        )
    }
}