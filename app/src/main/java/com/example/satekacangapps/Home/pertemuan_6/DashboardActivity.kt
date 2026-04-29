package com.example.satekacangapps.Home.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.satekacangapps.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val sessionManager = SessionManager(this)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Ambil nama dari session
        val username = sessionManager.getUsername()
        tvWelcome.text = "Halo, $username"

        btnLogout.setOnClickListener {
            // Tampilkan Alert Dialog Konfirmasi Logout
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah Anda yakin ingin keluar dari akun?")
            
            builder.setPositiveButton("Ya") { dialog, which ->
                sessionManager.logout() // Hapus Session
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            builder.setNegativeButton("Tidak") { dialog, which ->
                dialog.dismiss()
            }

            val alert = builder.create()
            alert.show()
        }
    }
}