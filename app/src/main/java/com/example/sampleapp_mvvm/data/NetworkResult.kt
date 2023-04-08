package com.example.sampleapp_mvvm.data

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Loading<T> : NetworkResult<T>()
    class Fail<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)
}