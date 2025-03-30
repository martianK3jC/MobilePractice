package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.mobilepractice.app.MyApplication

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button_login = findViewById<Button>(R.id.button_login)
        val tv_fullname = findViewById<TextView>(R.id.tv_fullname)

        // Get fullname from application storage
        tv_fullname.text = (application as MyApplication).fullname

        // Handle login button click
        button_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Lesson: Passing data via Intent
        /*
        intent?.let {
            it.getStringExtra("fullname")?.let { fullname ->
                tv_fullname.text = fullname
            }
        }
        */
    }
}
