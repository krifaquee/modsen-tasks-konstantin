package com.example.modsentaskskonstantin.domain.usecase


import com.example.modsentaskskonstantin.domain.model.TaskDomainModel
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository

class GetTasksUseCase(
    private val repo: ITaskRepository
) {
    suspend operator fun invoke(): List<TaskDomainModel> = repo.getAllTasks()
}
