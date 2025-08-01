package com.presentation.states

import com.domain.product.models.ProductDetails

sealed class ProductDetailsUiState {
    object Loading : ProductDetailsUiState()
    data class Success(val products: ProductDetails) : ProductDetailsUiState()
    data class Error(val message: String) : ProductDetailsUiState()
}
