package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val ISBN: String = "",
    val bookDetail: BookDetail? = null,
    val createdAt: String = "",
    val createdBy: Int = 0,
    val id: Int = 0,
    val publishingDate: String = "",
    val title: String = "",
    val updatedAt: String = "",
    val updatedBy: String = ""
) : Parcelable


