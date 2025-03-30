package com.android.mobilepractice.utils

import android.app.Activity
import android.app.Application
import android.widget.EditText
import android.widget.Toast

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun EditText.toText(): String {
    return this.text.toString()
}

fun EditText.isNotValid(): Boolean {
    return this.text.toString().trim().isEmpty()
}
