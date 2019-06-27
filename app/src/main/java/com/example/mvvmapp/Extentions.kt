package com.example.mvvmapp

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.getText(): String {
    return this.editText?.text.toString()
}