package com.inficare.agentapp.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.inficare.agentapp.BEARER
import com.inficare.agentapp.R
import com.inficare.agentapp.getText
import com.inficare.agentapp.repository.datasets.State
import dagger.android.AndroidInjection
import de.adorsys.android.securestoragelibrary.SecurePreferences
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        initViewStates()

        btnLogin.setOnClickListener {
            viewModel.requestLogin(etUsername.getText(), etPassword.getText())
        }
        btnLoadCatalog.setOnClickListener {
            viewModel.loadCatalog()
        }

    }

    private fun initViewStates() {
        viewModel.loginStateLiveData.observe(this, Observer {
            assert(it != null)

            when (it.state) {
                State.SUCCESS -> {
                    Log.e("test", "Test:" + SecurePreferences.getStringValue(BEARER, ""))
                }
                State.FAILED -> {
                    Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

        })

        viewModel.catalogListLiveData.observe(this, Observer {
            if (it == null) return@Observer

            for (catalog in it) {
                textView.append("${catalog.faceValue} \n")
            }
        })
    }


}
