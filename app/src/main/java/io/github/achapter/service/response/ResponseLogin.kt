package io.github.achapter.service.response
import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    val data: Data,
    val error: String,
    val message: String,
    val status: Int,
    val token: Token
)

data class Data(
    val address: String,
    val email: String,
    val id: Int,
    val name: String
)

data class Token(
    val exp_at: Int,
    val token: String
)