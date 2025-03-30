package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.mobilepractice.utils.isNotValid
import com.android.mobilepractice.utils.toast

class LoginActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button_login = findViewById<Button>(R.id.button_login)
        val button_register = findViewById<Button>(R.id.button_register)
        val edit_text_username = findViewById<EditText>(R.id.edit_text_username)
        val edit_text_password = findViewById<EditText>(R.id.edit_text_password)

        val username = "kesha"
        val password = "password123"

//        button_login.setOnClickListener {
//            if(edit_text_username.isNotValid() || edit_text_password.isNotValid()){
//                toast("Please fill out all the forms")
//                return@setOnClickListener
//            }
//            if(edit_text_username.toString().equals(username) && edit_text_password.toString().equals(password)){
//                navigateToHome()
//            }else{
//                toast("Invalid credentials")
//            }
//        }

        button_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}