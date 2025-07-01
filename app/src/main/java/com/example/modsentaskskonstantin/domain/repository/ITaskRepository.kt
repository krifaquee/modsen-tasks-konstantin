package com.example.modsentaskskonstantin.domain.repository

import com.example.modsentaskskonstantin.domain.model.TaskDomainModel

interface ITaskRepository {
    suspend fun getAllTasks(): List<TaskDomainModel>
}