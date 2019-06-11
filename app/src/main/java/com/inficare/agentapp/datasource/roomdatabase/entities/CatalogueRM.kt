package com.inficare.agentapp.datasource.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatalogueRM(
    @PrimaryKey var id: String,
    var data: String,
    var faceValue: String,
    var additionalData: String = "",
    var additionalValue: String = "",
    var additionalValue2: String = "",
    var language: String = "en"
)