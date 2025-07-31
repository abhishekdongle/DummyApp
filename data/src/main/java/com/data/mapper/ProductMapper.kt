package com.data.mapper

import com.domain.models.Product
import com.network.model.ProductDto

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        thumbnail = thumbnail
    )
}
