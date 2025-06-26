package com.example.modsentaskskonstantin.data.network.model

import com.example.modsentaskskonstantin.domain.model.PostDomainModel

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
    fun toDomain(): PostDomainModel =
        PostDomainModel(userId, id, title, body)
}
