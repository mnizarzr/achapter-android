package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feed(
    val `data`: List<BookDisplay> = listOf(),
    val feed_name: String = "",
    val title: String = ""
) : Parcelable