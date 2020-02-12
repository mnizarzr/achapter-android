package io.github.achapter.model

import android.os.Parcelable
import io.github.achapter.BuildConfig
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDetail(
    val authors: List<Author>,
    val description: String,
    val dimension: String,
    val discount: Int,
    val genres: List<Genre>,
    val id: Int,
    val isbn: String,
    val language: String,
    val pages: Int,
    val picture: String,
    val price: Int,
    val publisher: String,
    val publishing_date: String,
    val stock: Int,
    val title: String,
    val weight: String
) : Parcelable {

    fun getImageUrl() = "${BuildConfig.BASE_URL}storage/books/$picture"

}