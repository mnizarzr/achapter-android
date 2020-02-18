package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feed(
    val `data`: ArrayList<BookDisplay> = arrayListOf(),
    val feedName: String = "",
    val title: String = ""
) : Parcelable