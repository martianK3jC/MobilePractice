package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.mobilepractice.utils.isNotValid
import com.android.mobilepractice.utils.toast

class RegisterActivity : Activity() {
    private lateinit var loginButton : Button
    private lateinit var registerButton : Button
    private lateinit var edit_text_username : EditText
    private lateinit var edit_text_password : EditText
    private lateinit var edit_text_confirm_password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setUpButtons()

    }

    private fun initializeViews(){
        loginButton = findViewById(R.id.button_login)
        registerButton = findViewById(R.id.button_register)
        edit_text_username = findViewById(R.id.edit_text_username)
        edit_text_password = findViewById(R.id.edit_text_password)
        edit_text_confirm_password = findViewById(R.id.edit_text_confirm_password)
    }

    private fun setUpButtons(){
        loginButton.setOnClickListener {
            navigateToLogin()
        }

        registerButton.setOnClickListener {
            Toast.makeText(this, "Register button is clicked!", Toast.LENGTH_SHORT).show()
            if(edit_text_username.isNotValid() || edit_text_username.isNotValid() || edit_text_confirm_password.isNotValid()){
                toast("Please fill out all the forms")
                return@setOnClickListener
            }
        }
    }

    private fun navigateToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}