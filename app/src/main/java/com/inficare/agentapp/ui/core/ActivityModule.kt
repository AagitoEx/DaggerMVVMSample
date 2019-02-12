package com.inficare.agentapp.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.inficare.agentapp.repository.AuthenticationRepository
import com.inficare.agentapp.repository.CatalogueRepository
import com.inficare.agentapp.repository.CustomerRepository
import com.inficare.agentapp.ui.main.MainActivity
import com.inficare.agentapp.ui.main.MainActivityViewModel
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
        fun provideMainActivityViewModel(authenticationRepository: AuthenticationRepository,
                                         catalogueRepository: CatalogueRepository,
                                         customerRepository: CustomerRepository
        ): ViewModel = MainActivityViewModel(authenticationRepository, catalogueRepository, customerRepository)
    }
}