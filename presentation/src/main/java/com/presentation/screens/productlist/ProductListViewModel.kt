package com.presentation.screens.productlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.models.Product
import com.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                println("xxx getProductsUseCase")
                getProductsUseCase()
                _products.value = getProductsUseCaseH()
            } catch (e: Exception) {
                println(e.printStackTrace())
            }
        }
    }

    private fun getProductsUseCaseH(): List<Product> =
        listOf(
            Product(
                id = 1,
                title = "iPhone 9",
                description = "An apple mobile which is nothing like apple",
                thumbnail = "https://images.pexels.com/photos/29020349/pexels-photo-29020349.jpeg"
            ),
            Product(
                id = 2,
                title = "Samsung Galaxy Book",
                description = "Premium laptop for professionals",
                thumbnail = "https://images.pexels.com/photos/2825352/pexels-photo-2825352.jpeg"
            )
        )
}
