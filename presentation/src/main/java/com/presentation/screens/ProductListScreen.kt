package com.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.data.models.Product
import com.presentation.components.ProductItem

@Composable
fun ProductListScreen() {
    val sampleProducts = listOf(
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

    ProductList(products = sampleProducts)
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
