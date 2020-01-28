package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author(
    val id: Int? = 0,
    val name: String? = ""
) : Parcelable