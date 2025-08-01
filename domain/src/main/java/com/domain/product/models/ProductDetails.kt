package com.domain.product.models

data class ProductDetails(
    val images: List<String>? = null,
    val title: String? = null,
    val description: String? = null,
    val rating: Double? = null,
    val category: String? = null,
    val price: Double? = null
)
