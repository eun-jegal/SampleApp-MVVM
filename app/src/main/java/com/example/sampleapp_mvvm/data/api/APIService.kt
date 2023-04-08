package com.example.sampleapp_mvvm.data.api

import com.example.sampleapp_mvvm.data.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("users")
    suspend fun getUsers(): Response<Users>
}