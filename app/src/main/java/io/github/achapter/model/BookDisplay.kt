package io.github.achapter.model

import android.os.Parcelable
import io.github.achapter.BuildConfig
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDisplay(
    val authors: ArrayList<Author> = arrayListOf(),
    val boughtCount: Int = 0,
    val discount: Int = 0,
    val id: Int = 0,
    val isbn: String = "",
    val picture: String = "",
    val price: Int = 0,
    val title: String = ""
) : Parcelable {

    fun getImageUrl() = "${BuildConfig.BASE_URL}storage/books/$picture"

}