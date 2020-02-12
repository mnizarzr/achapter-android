package io.github.achapter.model

data class User(
    val address: String? = "",
    val email: String = "",
    val id: Int = 0,
    val name: String = ""
)

data class Token(
    val exp_at: Int = 0,
    val token: String = ""
)