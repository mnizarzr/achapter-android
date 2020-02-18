package io.github.achapter.service.response

data class Response<T>(
    val `data`: ArrayList<T>,
    val status: Int,
    val error: String,
    val message: String
)