package com.domain.product.usecase

import com.domain.product.models.ProductDetails
import com.domain.product.repository.ProductDetailsRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val repository: ProductDetailsRepository
) {
    suspend operator fun invoke(id: Int): ProductDetails {
        return repository.getProductById(id)
    }
}