package io.github.achapter.service.response

import io.github.achapter.model.Feed

data class FeedResponse(
    val `data`: List<Feed> = listOf(),
    val error: String? = "",
    val message: String = "",
    val status: Int = 0
)