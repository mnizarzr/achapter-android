package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookFeed(
    val id: Int = 0,
    val authors: ArrayList<Author> = arrayListOf(),
    val discount: Int = 0,
    val isbn: String = "",
    val picture: String? = "",
    val price: Int = 0,
    val title: String = ""
) : Parcelable {

    fun getImageUrl(): String = "http://192.168.1.100:8000/storage/books/$picture"

}