package com.data.product.mapper

import com.domain.product.models.ProductDetails
import com.network.model.ProductDetailsDto

fun ProductDetailsDto.toDomain(): ProductDetails {
    return ProductDetails(
        images = images.orEmpty(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        rating = rating ?: 0.0,
        category = category.orEmpty(),
        price = price ?: 0.0
    )
}
