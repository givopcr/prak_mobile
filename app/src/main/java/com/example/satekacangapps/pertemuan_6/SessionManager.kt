package com.example.satekacangapps.pertemuan_6

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    fun createLoginSession(username: String) {
        val editor = prefs.edit()
        editor.putBoolean("IS_LOGGED_IN", true)
        editor.putString("USERNAME", username)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("IS_LOGGED_IN", false)
    }

    fun getUsername(): String? {
        return prefs.getString("USERNAME", "Nasabah")
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}