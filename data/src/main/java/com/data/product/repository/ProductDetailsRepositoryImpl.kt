package com.data.product.repository

import com.data.product.mapper.toDomain
import com.domain.product.models.ProductDetails
import com.domain.product.repository.ProductDetailsRepository
import com.network.api.ProductDetailsApi
import javax.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(
    private val api: ProductDetailsApi
) : ProductDetailsRepository {

    override suspend fun getProductById(id: Int): ProductDetails {
        return api.getProductById(id).toDomain()
    }
}
