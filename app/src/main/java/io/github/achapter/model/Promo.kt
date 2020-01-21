package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Promo(
    val id: Int,
    val text: String,
    val banner: String
) : Parcelable {

    override fun toString(): String {
        return "Promo={id=${id}, text=${text}, banner=${banner}}"
    }

}