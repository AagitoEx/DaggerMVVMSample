package com.inficare.agentapp.datasource

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.inficare.agentapp.BASE_URL
import com.inficare.agentapp.datasource.networksource.AuthNetworkService
import com.inficare.agentapp.datasource.networksource.AuthenticationInterceptor
import com.inficare.agentapp.datasource.networksource.NetworkService
import com.inficare.agentapp.datasource.roomdatabase.MainDatabase
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMainDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            "agents.db"
        ).build()

    @Provides
    @Singleton
    fun provideCatalogDao(mainDatabase: MainDatabase) = mainDatabase.catalogDao()

    /*@Singleton
    @Provides
    fun providesSharedPreferenceUtils(application: Application): SharedPreferenceUtils {
        return SharedPreferenceUtils(application)
    }*/

    // --- NETWORK INJECTION ---
    @Provides
    fun provideGson(): GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHttpClient(logging: HttpLoggingInterceptor, auth: AuthenticationInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(auth)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiAuthWebservice(restAdapter: Retrofit): AuthNetworkService {
        return restAdapter.create<AuthNetworkService>(AuthNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiNetworkWebservice(restAdapter: Retrofit): NetworkService {
        return restAdapter.create<NetworkService>(NetworkService::class.java)
    }
}