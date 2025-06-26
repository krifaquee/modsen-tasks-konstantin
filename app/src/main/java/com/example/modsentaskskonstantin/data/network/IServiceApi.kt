package com.example.modsentaskskonstantin.data.network

import com.example.modsentaskskonstantin.data.network.model.PostDto
import retrofit2.http.GET

interface IServiceApi {
    @GET("posts")
    suspend fun fetchPosts(): List<PostDto>
}
