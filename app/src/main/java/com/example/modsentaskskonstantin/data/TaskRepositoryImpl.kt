package com.example.modsentaskskonstantin.data

<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.model.TaskDomainModel
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository
import kotlinx.coroutines.delay

class TaskRepositoryImpl : ITaskRepository {
    override suspend fun getAllTasks(): List<TaskDomainModel> {
        delay(500)
        return listOf(
            TaskDomainModel(id = "1", title = "Задание №1"),
            TaskDomainModel(id = "2", title = "Задание №2")
=======
import com.example.modsentaskskonstantin.domain.model.Task
import com.example.modsentaskskonstantin.domain.repository.TaskRepository
import kotlinx.coroutines.delay

class TaskRepositoryImpl : TaskRepository {
    override suspend fun getAllTasks(): List<Task> {
        delay(500)
        return listOf(
            Task(id = "1", title = "Задание №1")
>>>>>>> main
        )
    }
}