package com.domain.product.usecase

import com.domain.product.models.Product
import com.domain.product.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.getAllProducts()
    }
}
