package com.domain.product.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int?,
    val title: String?,
    val description: String?,
    val thumbnail: String?
) : Parcelable
