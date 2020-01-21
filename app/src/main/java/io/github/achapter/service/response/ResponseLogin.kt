package io.github.achapter.service.response

data class ResponseLogin(
    val status: Int,
    val error: String,
    val data: String
)