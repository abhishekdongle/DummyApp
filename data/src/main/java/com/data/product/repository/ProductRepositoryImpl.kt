package com.data.product.repository

import com.data.product.mapper.toDomain
import com.domain.product.repository.ProductRepository
import com.network.api.ProductApi
import com.domain.product.models.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getAllProducts(): List<Product> {
        val response = api.getProducts()
        return response.products?.map { it.toDomain() } ?: emptyList()
    }
}
