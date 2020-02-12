package io.github.achapter.service.response

import io.github.achapter.model.BookDetail

data class BookDetailResponse(
    val `data`: BookDetail,
    val error: String? = null,
    val message: String,
    val status: Int
)