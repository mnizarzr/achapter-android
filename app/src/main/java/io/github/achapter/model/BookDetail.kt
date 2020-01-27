package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDetail(
    val bookId: Int = 0,
    val boughtCount: Int = 0,
    val description: String? = "",
    val discount: Int = 0,
    val height: Int = 0,
    val language: String = "",
    val pages: Int = 0,
    val pictures: String = "",
    val price: Int = 0,
    val stock: Int = 0,
    val weight: Int = 0,
    val width: Int = 0
) : Parcelable