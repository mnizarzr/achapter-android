package io.github.achapter.service.response

data class RegisterResponse(
    val `data`: Register,
    val error: String? = "",
    val message: String,
    val status: Int
)

data class Register(
    val created_at: String,
    val email: String,
    val id: Int,
    val name: String,
    val role: String,
    val updated_at: String
)