package com.inficare.agentapp.datasource.networksource.responsemodels

import com.google.gson.annotations.SerializedName


data class CatalogueItem(
    @SerializedName("additional_data")
    val additionalData: String = "",
    @SerializedName("additional_value2")
    val additionalValue2: String = "",
    @SerializedName("data")
    val data: String = "",
    @SerializedName("language")
    val language: String = "",
    @SerializedName("additional_value")
    val additionalValue: String = "",
    @SerializedName("value")
    val value: String = ""
)

