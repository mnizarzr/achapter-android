package io.github.achapter.service.response

import com.google.gson.annotations.SerializedName
import io.github.achapter.model.Token
import io.github.achapter.model.User

data class LoginResponse(
    @SerializedName("data")
    val `data`: User = User(),
    val error: String = "",
    val message: String = "",
    val status: Int = 0,
    val token: Token = Token()
)