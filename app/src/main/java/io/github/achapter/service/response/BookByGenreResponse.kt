package io.github.achapter.service.response

import io.github.achapter.model.BookFeed

data class BookByGenreResponse(
    val `data`: Genre? = Genre(),
    val error: String? = "",
    val message: String = "",
    val status: Int = 0
)

data class Genre(
    val books: ArrayList<BookFeed> = arrayListOf(),
    val id: Int = 0,
    val name: String = ""
)