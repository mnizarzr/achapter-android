package io.github.achapter.util

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import timber.log.Timber

class PreferenceHelper(private val context: Context) {

    companion object {
        const val USER_INFO = "USER_INFO"
        const val TOKEN = "TOKEN"
    }

    private fun getDefaultPreference(): SharedPreferences {
        return context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE)
    }

    private fun getTokenPreference(): SharedPreferences {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            EncryptedSharedPreferences.create(
                TOKEN,
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } else {
            context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE)
        }
    }

    fun setToken(value: String) {
        getTokenPreference().edit().putString("token", value).apply()
    }

    fun getToken(): String = getTokenPreference().getString("token", "")!!

    fun setBoolean(key: String, value: Boolean){
        getDefaultPreference().edit().putBoolean(key, value).apply()
    }

    fun setString(key: String, value: String){
        getDefaultPreference().edit().putString(key, value).apply()
    }

    fun setInt(key: String, value: Int){
        getDefaultPreference().edit().putInt(key, value).apply()
    }

    fun getString(key: String): String = getDefaultPreference().getString(key, "")!!
    fun getBoolean(key: String): Boolean = getDefaultPreference().getBoolean(key, false)
    fun getInt(key: String): Int = getDefaultPreference().getInt(key, 0)

}