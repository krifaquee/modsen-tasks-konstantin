package com.example.modsentaskskonstantin.domain.usecase

import com.example.modsentaskskonstantin.domain.model.Task
import com.example.modsentaskskonstantin.domain.repository.TaskRepository

class GetTasksUseCase(
    private val repo: TaskRepository
) {
    suspend operator fun invoke(): List<Task> = repo.getAllTasks()
}
