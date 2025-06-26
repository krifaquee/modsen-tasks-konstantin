package com.example.modsentaskskonstantin.domain.usecase

<<<<<<< task-1-1
import com.example.modsentaskskonstantin.domain.model.TaskDomainModel
import com.example.modsentaskskonstantin.domain.repository.ITaskRepository

class GetTasksUseCase(
    private val repo: ITaskRepository
) {
    suspend operator fun invoke(): List<TaskDomainModel> = repo.getAllTasks()
=======
import com.example.modsentaskskonstantin.domain.model.Task
import com.example.modsentaskskonstantin.domain.repository.TaskRepository

class GetTasksUseCase(
    private val repo: TaskRepository
) {
    suspend operator fun invoke(): List<Task> = repo.getAllTasks()
>>>>>>> main
}
