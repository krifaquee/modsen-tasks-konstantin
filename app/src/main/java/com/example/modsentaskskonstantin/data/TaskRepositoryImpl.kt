package com.example.modsentaskskonstantin.data

import com.example.modsentaskskonstantin.domain.model.TaskDomainModel
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository
import kotlinx.coroutines.delay

class TaskRepositoryImpl : ITaskRepository {
    override suspend fun getAllTasks(): List<TaskDomainModel> {
        delay(500)
        return listOf(
            TaskDomainModel(id = "1", title = "Задание №1"),
            TaskDomainModel(id = "2", title = "Задание №2")
        )
    }
}