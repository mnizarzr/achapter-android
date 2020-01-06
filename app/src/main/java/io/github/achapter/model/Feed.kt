package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feed(
    var title: String = "",
    var items: ArrayList<BookDisplay>? = null
) : Parcelable