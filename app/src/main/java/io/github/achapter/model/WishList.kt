package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WishList(
    var nama: String = "",
    var harga: String = "",
    var photo: String = ""
) : Parcelable