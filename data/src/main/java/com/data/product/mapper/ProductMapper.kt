package com.data.product.mapper

import com.domain.product.models.Product
import com.network.model.ProductDto

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title.orEmpty(),
        description = description.orEmpty(),
        thumbnail = thumbnail.orEmpty()
    )
}
