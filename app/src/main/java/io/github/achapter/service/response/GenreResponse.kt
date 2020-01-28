package io.github.achapter.service.response

import io.github.achapter.model.Genre

data class GenreResponse(
    val `data`: ArrayList<Genre>? = arrayListOf(),
    val error: String? = "",
    val message: String? = "",
    val status: Int? = 0
)