package com.presentation.screens.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.domain.product.models.Product
import com.presentation.components.ErrorView
import com.presentation.components.HeaderComponent
import com.presentation.components.LoadingView
import com.presentation.states.ProductUiState

@Composable
fun ProductListScreen(
    onProductClick: (Product?) -> Unit = {},
    productListViewModel: ProductListViewModel = hiltViewModel()
) {
    val uiState by productListViewModel.uiState.collectAsState()

    Column {
        HeaderComponent("Product List")
        when (uiState) {
            ProductUiState.Loading -> {
                LoadingView()
            }

            is ProductUiState.Success -> {
                val products = (uiState as ProductUiState.Success).products
                ProductList(products = products, onProductClick = onProductClick)
            }

            is ProductUiState.Error -> {
                val errorMessage = (uiState as ProductUiState.Error).message
                ErrorView(errorMessage = errorMessage)
            }
        }
    }
}

@Composable
private fun ProductList(products: List<Product>, onProductClick: (Product?) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) { product ->
            ProductItemCard(product, onClick = { selectedProduct ->
                onProductClick(selectedProduct)
            })
        }
    }
}
