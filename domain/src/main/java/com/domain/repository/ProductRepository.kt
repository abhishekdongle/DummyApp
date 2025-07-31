package com.domain.repository

import com.domain.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}
