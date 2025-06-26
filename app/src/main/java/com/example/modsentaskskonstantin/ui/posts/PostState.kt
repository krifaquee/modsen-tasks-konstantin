package com.example.modsentaskskonstantin.ui.posts

import com.example.modsentaskskonstantin.domain.model.PostDomainModel

data class PostState(
    val posts: List<PostDomainModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
