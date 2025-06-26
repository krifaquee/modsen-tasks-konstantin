package com.example.modsentaskskonstantin.domain.usecase

import com.example.modsentaskskonstantin.domain.model.PostDomainModel
import com.example.modsentaskskonstantin.domain.repository.IPostRepository

class GetPostsUseCase(
    private val repo: IPostRepository
) {
    suspend operator fun invoke(): List<PostDomainModel> =
        repo.getPosts()
}
