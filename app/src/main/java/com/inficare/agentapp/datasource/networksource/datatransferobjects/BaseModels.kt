package com.inficare.agentapp.datasource.networksource.datatransferobjects

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("code")
    val code: String = "",
    @SerializedName("result")
    val catalogueList: T?,
    @SerializedName("message")
    val message: String = ""
)

data class AddressInfo(
    @SerializedName("address_country_code")
    val addressCountryCode: String = "",
    @SerializedName("address_city_town")
    val addressCityTown: String = "",
    @SerializedName("address_street")
    val addressStreet: String = "",
    @SerializedName("zip_code")
    val zipCode: String = "",
    @SerializedName("address_state_province")
    val addressStateProvince: String = ""
)

data class NameInfo(
    @SerializedName("last_name2")
    val lastName2: String = "",
    @SerializedName("last_name")
    val lastName: String = "",
    @SerializedName("middle_name")
    val middleName: String = "",
    @SerializedName("first_name")
    val firstName: String = ""
)

data class AccountDetail(
    @SerializedName("branch_code")
    val branchCode: String = "",
    @SerializedName("bank_code")
    val bankCode: String = "",
    @SerializedName("account_number")
    val accountNumber: String = "",
    @SerializedName("branch_name")
    val branchName: String = "",
    @SerializedName("account_name")
    val accountName: String = "",
    @SerializedName("bank_name")
    val bankName: String = "",
    @SerializedName("deposit_type_code")
    val depositTypeCode: String = ""
)