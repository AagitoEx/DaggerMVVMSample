package com.inficare.agentapp.datasource.networksource.responsemodels


import com.google.gson.annotations.SerializedName


data class MemberInfo(
    @SerializedName("isemailverified")
    val isemailverified: Boolean = false,
    @SerializedName("mail_display_language")
    val mailDisplayLanguage: String = "",
    @SerializedName("address_info")
    val addressInfo: AddressInfo,
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("name_info")
    val nameInfo: NameInfo,
    @SerializedName("last_login")
    val lastLogin: String = "",
    @SerializedName("date_of_birth")
    val dateOfBirth: String = "",
    @SerializedName("isemail2verified")
    val isemailVerified: Boolean = false,
    @SerializedName("sendermobile")
    val sendermobile: String = "",
    @SerializedName("account_detail")
    val accountDetail: AccountDetail,
    @SerializedName("sendernativecountry")
    val sendernativecountry: String = "",
    @SerializedName("user_login_id")
    val userLoginId: String = "",
    @SerializedName("senderemail")
    val senderemail: String = "",
    @SerializedName("senderemail2")
    val senderemail2: String = ""
)





