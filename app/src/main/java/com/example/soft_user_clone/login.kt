package com.example.soft_user_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var logged : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        logged = findViewById(R.id.btnlogged)
        logged.setOnClickListener {
            if(validate()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
    private fun validate() : Boolean {
        when {
            TextUtils.isEmpty(username.text) -> {
                username.error = "Username must not be empty"
                username.requestFocus()
                return false
            }
            TextUtils.isEmpty(password.text) -> {
                password.error = "Password must not be empty"
                password.requestFocus()
                return false
            }
            username.text.toString() != "softwarica" -> {
                username.error = "Usernaem is incorrect."
                username.requestFocus()
                return false
            }
            password.text.toString() != "coventry" -> {
                password.error = "Password is incorrect."
                password.requestFocus()
                return false
            }
            else -> return true
        }

    }
}