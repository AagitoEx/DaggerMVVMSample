package com.inficare.agentapp.datasource.networksource.datatransferobjects

import com.google.gson.annotations.SerializedName

class AuthResponse {
    var access_token: String? = null
    var token_type: String? = null
    var expires_in: Int = 0
    var userName: String? = null
    @SerializedName(".issued")
    var issueIn: String? = null
    @SerializedName(".expires")
    var expiresIn: String? = null
}
