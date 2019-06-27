package com.example.mvvmapp.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmapp.repository.AuthenticationRepository
import com.example.mvvmapp.ui.main.MainActivity
import com.example.mvvmapp.ui.main.MainActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module(
    includes = [ActivityModule.ProvideViewModel::class]
)
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [InjectViewModel::class])
    abstract fun contributeActivityAndroidInjector(): MainActivity

    @Module
    class InjectViewModel {

        @Provides
        fun provideMainActivityViewModel(
            factory: ViewModelProvider.Factory,
            target: MainActivity
        ) = ViewModelProviders.of(target, factory).get(MainActivityViewModel::class.java)
    }

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        fun provideMainActivityViewModel(authenticationRepository: AuthenticationRepository
        ): ViewModel = MainActivityViewModel(authenticationRepository)
    }
}