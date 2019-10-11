package com.example.space_task1.service.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    val originalUrl: String?=null,
    val thumbnailUrl: String?=null
): Parcelable