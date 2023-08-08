package com.example.sampleapp_mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp_mvvm.data.NetworkResult
import com.example.sampleapp_mvvm.data.repository.Repository
import com.example.sampleapp_mvvm.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _users = MutableStateFlow<NetworkResult<List<User>>>(NetworkResult.Loading())
    val users: StateFlow<NetworkResult<List<User>>> = _users

    fun fetchUserData() {
        viewModelScope.launch {
            repository.getUsers().collect { result ->
                _users.value = result
            }
        }
    }
}