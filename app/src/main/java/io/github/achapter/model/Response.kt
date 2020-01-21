package io.github.achapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Response(
    var status: Int? = null,
    var error: String? = null,
    var data: @RawValue List<Any>? = null
) : Parcelable
