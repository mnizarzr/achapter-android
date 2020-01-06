package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val bookId: Int,
    val title: String,
    val isbn: String,
    val publisherId: Int,
    val publishingDate: String,
    val price: Int,
    val discount: Int,
    val cover: String,
    val detail: BookDetail
) : Parcelable