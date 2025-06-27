package com.example.modsentaskskonstantin.data.repository

import com.example.modsentaskskonstantin.data.network.IServiceApi
import com.example.modsentaskskonstantin.domain.model.PostDomainModel
import com.example.modsentaskskonstantin.domain.repository.IPostRepository

class PostRepositoryImpl(
    private val api: IServiceApi
) : IPostRepository {
    override suspend fun getPosts(): List<PostDomainModel> =
        api.fetchPosts().map { it.toDomain() }
}
