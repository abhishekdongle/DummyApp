package com.data.repository

import com.data.mapper.toDomain
import com.domain.repository.ProductRepository
import com.network.api.ProductApi
import com.domain.models.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        val productsDto = api.getProducts()
        println("xxx productsDto = $productsDto")
        return productsDto.map { it.toDomain() }
    }
}
