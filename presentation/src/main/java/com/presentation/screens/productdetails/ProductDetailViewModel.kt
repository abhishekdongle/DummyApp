package com.presentation.screens.productdetails

import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.product.usecase.GetProductDetailsUseCase
import com.presentation.states.ProductDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductDetailsUiState>(ProductDetailsUiState.Loading)
    val uiState: StateFlow<ProductDetailsUiState> = _uiState

    fun onAction(id: Int?) {
        id?.let { getProductDetails(id) }
    }

    private fun getProductDetails(id: Int) {
        viewModelScope.launch {
            try {
                val products = getProductDetailsUseCase(id)
                _uiState.value = ProductDetailsUiState.Success(products)
            } catch (e: Exception) {
                _uiState.value = ProductDetailsUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}
