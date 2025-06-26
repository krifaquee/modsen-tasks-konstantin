package com.example.modsentaskskonstantin.domain.repository

import com.example.modsentaskskonstantin.domain.model.PostDomainModel

interface IPostRepository {
    suspend fun getPosts(): List<PostDomainModel>
}
