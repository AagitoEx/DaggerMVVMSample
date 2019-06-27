package com.example.mvvmapp.repository

import com.example.mvvmapp.BEARER
import com.example.mvvmapp.datasource.networksource.AuthNetworkService
import com.example.mvvmapp.repository.datasets.ResultState
import de.adorsys.android.securestoragelibrary.SecurePreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(private var authNetworkService: AuthNetworkService) {

    private val compositeDisposable = CompositeDisposable()

    fun loginUser(username: String, password: String, onLoginResponse: (ResultState, message: String) -> Unit) {

        val disposable = authNetworkService.requestLogin(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    SecurePreferences.setValue(BEARER, it.access_token!!)
                    onLoginResponse(ResultState.SUCCESS, "")

                }, {
                    onLoginResponse(ResultState.FAILED, it.message!!)
                }
            )

        compositeDisposable.add(disposable)
    }

    fun clearDisposables() {
        compositeDisposable.clear()
    }



}