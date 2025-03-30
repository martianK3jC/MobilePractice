package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.mobilepractice.app.MyApplication
import com.android.mobilepractice.utils.isNotValid
import com.android.mobilepractice.utils.toText
import com.android.mobilepractice.utils.toast

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button_login = findViewById<Button>(R.id.button_login)
        val button_register = findViewById<Button>(R.id.button_register)
        val edit_text_fullname = findViewById<EditText>(R.id.edit_text_fullname)
        val edit_text_username = findViewById<EditText>(R.id.edit_text_username)
        val edit_text_password = findViewById<EditText>(R.id.edit_text_password)
        val edit_text_confirm_password = findViewById<EditText>(R.id.edit_text_confirm_password)

        button_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //PASS DATA TO LOGIN SCREEN
        button_register.setOnClickListener {
            if (edit_text_username.isNotValid() || edit_text_password.isNotValid() || edit_text_confirm_password.isNotValid()) {
                toast("Please fill out all the forms")
                return@setOnClickListener
            } else if (edit_text_password.text.toString() != edit_text_confirm_password.text.toString()) {
                toast("Passwords do not match")
                return@setOnClickListener
            }

//            startActivity(
//                Intent(this, LoginActivity::class.java).apply {
//                    putExtra("username", edit_text_username.text.toString())
//                    putExtra("password", edit_text_password.text.toString())
//                }
//            )

            //Instead of intent, we use the application
            //Pass data
            val intent = Intent(this, LoginActivity::class.java)
            (application as MyApplication).username = edit_text_username.toText()
            (application as MyApplication).password = edit_text_password.toText()
            (application as MyApplication).fullname = edit_text_fullname.toText()
            (application as MyApplication).fullname = edit_text_fullname.toText()
            startActivity(intent)
        }
    }
}
