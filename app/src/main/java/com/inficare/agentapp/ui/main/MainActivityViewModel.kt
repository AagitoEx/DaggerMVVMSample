package com.inficare.agentapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.inficare.agentapp.datasource.roomdatabase.localmodels.CatalogueRM
import com.inficare.agentapp.repository.AuthenticationRepository
import com.inficare.agentapp.repository.CatalogueRepository
import com.inficare.agentapp.repository.CustomerRepository
import com.inficare.agentapp.repository.datasets.COUNTRY_LIST
import com.inficare.agentapp.repository.datasets.ResponseState
import com.inficare.agentapp.ui.core.AppViewModel

class MainActivityViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val catalogueRepository: CatalogueRepository,
    private val customerRepository: CustomerRepository
) : AppViewModel() {


    val loginStateLiveData: MutableLiveData<ResponseState<String>> = MutableLiveData()
    var catalogListLiveData: LiveData<List<CatalogueRM>> = catalogueRepository.catalogLiveData

    fun requestLogin(username: String, password: String) {
        authenticationRepository.loginUser(username, password) {
            loginStateLiveData.value = it
        }
    }

    fun loadCatalog() {
        catalogueRepository.loadCatalog(COUNTRY_LIST)
        customerRepository.getMemberInfo("")
    }

    override fun onCleared() {
        super.onCleared()
        authenticationRepository.clearDisposables()
        catalogueRepository.clearDisposables()
    }
}