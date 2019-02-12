package com.inficare.agentapp.datasource.networksource

import com.inficare.agentapp.BEARER
import de.adorsys.android.securestoragelibrary.SecurePreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthenticationInterceptor
@Inject constructor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
        if (!request.url().toString().contains("/token")) {
            builder.addHeader("Authorization", "Bearer ${SecurePreferences.getStringValue(BEARER,"Authenticator Injected")!!}")
        }
        request = builder.build()
        return chain.proceed(request)
    }
}