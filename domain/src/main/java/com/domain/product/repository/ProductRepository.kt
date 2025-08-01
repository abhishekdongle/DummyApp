package com.domain.product.repository

import com.domain.product.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}
