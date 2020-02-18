package io.github.achapter.service.response

import io.github.achapter.model.Feed

data class FeedResponse(
    val `data`: ArrayList<Feed> = arrayListOf(),
    val error: String? = "",
    val message: String = "",
    val status: Int = 0
)