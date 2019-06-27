package com.example.mvvmapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.ui.core.AppViewModelFactory
import com.example.mvvmapp.ui.core.ActivityModule
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module(
    includes = [
        ActivityModule::class
    ]
)
class UiModule {

    @Provides
    fun provideViewModelFactory(
        providers: Map<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory = AppViewModelFactory(providers)

}