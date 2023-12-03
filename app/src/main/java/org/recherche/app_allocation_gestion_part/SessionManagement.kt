package org.recherche.app_allocation_gestion_part

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SessionManagement(application: Application) {
    private val sharedPreferences: SharedPreferences = application.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
    private val TOKEN = "TOKEN_"

    fun getToken(): String {
        val str = sharedPreferences.getString(TOKEN, "")
        return str!!
    }

    fun removeToken(): Boolean {
        val editor = sharedPreferences.edit()
        editor.remove(TOKEN)
        return true
    }

    fun addToken(string: String): Boolean {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN, string)
        editor.commit()
        return true
    }


}