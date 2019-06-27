package com.example.mvvmapp.datasource.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmapp.datasource.roomdatabase.dao.CatalogueDao
import com.example.mvvmapp.datasource.roomdatabase.entities.CatalogueRM


@Database(entities = [CatalogueRM::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {

    // --- DAO ---
    abstract fun catalogDao(): CatalogueDao

}