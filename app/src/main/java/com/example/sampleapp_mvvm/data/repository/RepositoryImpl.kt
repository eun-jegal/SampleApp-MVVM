package com.example.sampleapp_mvvm.data.repository

import com.example.sampleapp_mvvm.data.NetworkResult
import com.example.sampleapp_mvvm.data.api.APIService
import com.example.sampleapp_mvvm.data.model.Users
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val apiService: APIService
) : Repository {
    override suspend fun getUsers(): Flow<NetworkResult<Users>> {
        return flow {
            emit(NetworkResult.Loading())
            try {
                val response = apiService.getUsers()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(NetworkResult.Success(it))
                    }
                }
            } catch (e: Exception) {
                emit(NetworkResult.Fail(e.message.toString()))
            }
        }
    }
}