package com.inficare.agentapp

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import de.adorsys.android.securestoragelibrary.SecurePreferences
import javax.inject.Inject

class AgentApplication : Application(), HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        this.initDagger()
    }

    private fun initDagger() {
        component = DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()

        component.inject(this)
    }

    override fun supportFragmentInjector() = fragmentInjector

    override fun activityInjector() = activityInjector

}
