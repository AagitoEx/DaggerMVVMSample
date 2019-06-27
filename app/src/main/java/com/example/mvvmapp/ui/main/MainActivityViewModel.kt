package com.example.mvvmapp.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.mvvmapp.repository.AuthenticationRepository
import com.example.mvvmapp.repository.datasets.ResultState
import com.example.mvvmapp.ui.core.AppViewModel

class MainActivityViewModel(
    private val authenticationRepository: AuthenticationRepository
) : AppViewModel() {


    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    fun requestLogin(username: String, password: String) {
        authenticationRepository.loginUser(username, password) { state, message ->
            if (state == ResultState.FAILED)
                errorMessageLiveData.value = message
        }
    }

    override fun onCleared() {
        super.onCleared()
        authenticationRepository.clearDisposables()
    }
}