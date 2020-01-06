package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDetail(
    val description: String,
    val dimension: String,
    val pageCount: Int,
    val language: String,
    val stock: Int
) : Parcelable