package com.inficare.agentapp.repository

import android.util.Log
import com.inficare.agentapp.datasource.networksource.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CustomerRepository @Inject constructor(private var networkService: NetworkService) {

    private val compositeDisposable = CompositeDisposable()

    fun getMemberInfo(memberId: String) {
        val disposable = networkService.getCustomerDetails("A0000000001")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    if (it.code == "0")
                        Log.e("Test:", "Member decoding success")

                }, {
                    it.printStackTrace()
                }
            )
        compositeDisposable.add(disposable)
    }

    fun clearDisposables() {
        compositeDisposable.clear()
    }

}