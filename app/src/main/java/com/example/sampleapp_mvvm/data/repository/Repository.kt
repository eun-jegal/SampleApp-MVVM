package com.example.sampleapp_mvvm.data.repository

import com.example.sampleapp_mvvm.data.NetworkResult
import com.example.sampleapp_mvvm.domain.User
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getUsers(): Flow<NetworkResult<List<User>>>
}