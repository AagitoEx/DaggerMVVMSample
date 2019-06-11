package com.inficare.agentapp.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.inficare.agentapp.BEARER
import com.inficare.agentapp.R
import com.inficare.agentapp.getText
import com.inficare.agentapp.hello
import com.inficare.agentapp.repository.datasets.ResultState
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
        viewModel.errorMessageLiveData.observe(this, Observer {

        })

        viewModel.catalogListLiveData.observe(this, Observer {
            if (it == null) return@Observer

            for (catalog in it) {
                textView.append("${catalog.faceValue} \n")
            }
        })
    }


}
