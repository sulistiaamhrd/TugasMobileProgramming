package com.example.tugasmobileprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private val usernmane = "sulistiawaty";
    private val password = "tugas123";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val TxtUsername = findViewById<EditText>(R.id.editTextUsername) as EditText
        val TxtPassword = findViewById<EditText>(R.id.editTextPassword) as EditText
        val buttonLogin = findViewById<Button>(R.id.buttonLogin) as Button

        buttonLogin.setOnClickListener(View.OnClickListener {
            if (TxtUsername.text.toString() == usernmane || TxtPassword.text.toString() == password) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent) // Pindah ke MainActivity
                finish()
            } else {
                Toast.makeText(this, "Username dan Password Salah", Toast.LENGTH_LONG).show();
            }
        })
    }
}