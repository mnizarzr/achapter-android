package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feed(
    val title: String,
    val items: List<BookDisplay>
) : Parcelable