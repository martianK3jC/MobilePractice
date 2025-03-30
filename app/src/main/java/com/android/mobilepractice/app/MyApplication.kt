package com.android.mobilepractice.app

import android.app.Application
import android.os.Bundle
import android.util.Log

class MyApplication : Application() {
    //Declare and initialize attributes
    var username: String = ""
    var fullname: String = ""
    var password: String = ""
    override fun onCreate() {
        super.onCreate()

        //To see if the class is being called
        Log.e("Tutorial", "My application is called")
    }
}