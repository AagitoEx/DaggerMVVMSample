package com.inficare.agentapp.repository

import com.inficare.agentapp.datasource.networksource.NetworkService
import com.inficare.agentapp.datasource.roomdatabase.dao.CatalogueDao
import com.inficare.agentapp.datasource.roomdatabase.entities.CatalogueRM
import com.inficare.agentapp.repository.datasets.COUNTRY_LIST
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatalogueRepository @Inject constructor(
    private var networkService: NetworkService,
    private var catalogueDao: CatalogueDao
) {

    private val compositeDisposable = CompositeDisposable()
    val catalogLiveData = catalogueDao.getCatalog()

    fun loadCatalog(catalogType: String) {
        val disposable = networkService.getCatalogue(catalogType, "Ne")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    if (it.code == "0")

                        for (catalog in it.catalogueList!!) {
                            val catalogueRM = CatalogueRM(
                                COUNTRY_LIST + catalog.data,
                                catalog.data,
                                catalog.value
                            )

                            //insert to room db in background thread
                            Schedulers.io().createWorker().schedule {
                                catalogueDao.insertCatalog(catalogueRM)
                            }
                        }

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