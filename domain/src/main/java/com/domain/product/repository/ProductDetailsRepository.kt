package com.domain.product.repository

import com.domain.product.models.ProductDetails

interface ProductDetailsRepository {
    suspend fun getProductById(id: Int): ProductDetails
}
