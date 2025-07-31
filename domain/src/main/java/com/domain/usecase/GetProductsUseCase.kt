package com.domain.usecase

import com.domain.models.Product
import com.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        println("xxx products = ${repository.getAllProducts()}")
        return repository.getAllProducts()
    }
}
