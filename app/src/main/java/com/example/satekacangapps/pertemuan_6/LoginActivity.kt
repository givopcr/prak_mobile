package com.example.satekacangapps.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.satekacangapps.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sessionManager = SessionManager(this)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Tampilkan Alert Berhasil Login
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Login Berhasil")
                builder.setMessage("Selamat datang, $username!")
                builder.setPositiveButton("OK") { dialog, _ ->
                    sessionManager.createLoginSession(username)
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                builder.setCancelable(false)
                builder.show()
            } else {
                Toast.makeText(this, "Mohon isi User ID dan Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}