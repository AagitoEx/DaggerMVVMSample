package com.inficare.agentapp.datasource.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inficare.agentapp.datasource.roomdatabase.entities.CatalogueRM

@Dao
interface CatalogueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalog(catalogueRM: CatalogueRM)

    @Query("select * from cataloguerm")
    fun getCatalog(): LiveData<List<CatalogueRM>>

}