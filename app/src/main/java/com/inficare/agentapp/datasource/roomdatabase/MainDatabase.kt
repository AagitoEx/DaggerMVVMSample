package com.inficare.agentapp.datasource.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inficare.agentapp.datasource.roomdatabase.dao.CatalogueDao
import com.inficare.agentapp.datasource.roomdatabase.entities.CatalogueRM


@Database(entities = [CatalogueRM::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {

    // --- DAO ---
    abstract fun catalogDao(): CatalogueDao

}