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

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button_login = findViewById<Button>(R.id.button_login)
        val button_register = findViewById<Button>(R.id.button_register)
        val edit_text_username = findViewById<EditText>(R.id.edit_text_username)
        val edit_text_password = findViewById<EditText>(R.id.edit_text_password)
        val staticUsername = "kesha"
        val staticPassword = "password123"

//Lesson: Passing Data via intent
        //RECEIVE DATA FROM REGISTER SCREEN
//        intent?.let {
//            it.getStringExtra("username")?.let { username ->
//                edit_text_username.setText(username)
//            }
//
//            it.getStringExtra("password")?.let{ password ->
//                edit_text_password.setText(password)
//            }
//        }

        //Recieve data via application
        edit_text_username.setText((application as MyApplication).username ?: "")
        edit_text_password.setText((application as MyApplication).password ?: "")

        button_login.setOnClickListener {
            if(edit_text_username.isNotValid() || edit_text_password.isNotValid()){
                toast("Please fill out all the forms")
                return@setOnClickListener
            }

            if(edit_text_username.toText() == staticUsername && edit_text_password.toText() == staticPassword){
                navigateToHome()
            }else{
                toast("Invalid credentials")
                return@setOnClickListener
            }


        }

        button_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun navigateToHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}