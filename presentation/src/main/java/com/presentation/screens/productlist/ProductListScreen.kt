package com.presentation.screens.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.presentation.components.ProductItem
import androidx.hilt.navigation.compose.hiltViewModel
import com.domain.models.Product

@Composable
fun ProductListScreen(
    productListViewModel: ProductListViewModel = hiltViewModel()
) {
    ProductList(products = productListViewModel.products.value)
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}
