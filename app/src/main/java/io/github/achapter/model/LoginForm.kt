package io.github.achapter.model

import android.util.Patterns

data class LoginForm(
    val email: String,
    val password: String
) {

    fun isEmailValid() = Patterns.EMAIL_ADDRESS.matcher(email).matches()

}