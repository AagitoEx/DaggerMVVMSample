package com.example.mvvmapp

import android.app.Application
import android.content.Context
import com.example.mvvmapp.datasource.DataModule
import com.example.mvvmapp.ui.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, AndroidSupportInjectionModule::class, AndroidInjectionModule::class, UiModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(application: AgentApplication)

}