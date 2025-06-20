package com.example.modsentaskskonstantin.domain.repository

import com.example.modsentaskskonstantin.domain.model.Task

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
}