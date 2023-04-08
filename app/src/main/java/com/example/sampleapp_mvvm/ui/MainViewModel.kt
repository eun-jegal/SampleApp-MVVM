package com.example.sampleapp_mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp_mvvm.data.NetworkResult
import com.example.sampleapp_mvvm.data.model.Users
import com.example.sampleapp_mvvm.data.repository.Repository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _users = MutableStateFlow<NetworkResult<Users>>(NetworkResult.Loading())
    val users: StateFlow<NetworkResult<Users>> = _users

    fun fetchUserData() {
        viewModelScope.launch {
            repository.getUsers().collect { result ->
                _users.value = result
            }
        }
    }
}