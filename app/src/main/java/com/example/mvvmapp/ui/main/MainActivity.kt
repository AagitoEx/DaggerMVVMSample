package com.example.mvvmapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmapp.R
import com.example.mvvmapp.getText
import dagger.android.AndroidInjection
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

    }

    private fun initViewStates() {
        viewModel.errorMessageLiveData.observe(this, Observer {

        })
    }


}
