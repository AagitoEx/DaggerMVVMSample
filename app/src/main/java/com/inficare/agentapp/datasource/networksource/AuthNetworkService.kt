package com.inficare.agentapp.datasource.networksource

import com.inficare.agentapp.datasource.networksource.datatransferobjects.AuthResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthNetworkService {

    @FormUrlEncoded
    @POST("/token")
    fun requestLogin(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("grant_type") grantType: String = "password"
    ): Observable<AuthResponse>
}