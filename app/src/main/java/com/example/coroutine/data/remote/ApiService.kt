package com.example.coroutine.data.remote

import com.example.coroutine.data.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/posts/{id}")
    suspend fun getTodo(@Path("id") id: Int): Response<Post>
}