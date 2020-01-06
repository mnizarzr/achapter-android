package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDisplay(
    var title: String = "",
    var price: Int = 0,
    var cover: String = "",
    var discount: Int = 0
) : Parcelable