package com.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.domain.product.models.Product
import com.presentation.screens.productdetails.ProductDetailScreen
import com.presentation.screens.productlist.ProductListScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = "product_list") {
        composable("product_list") {
            ProductListScreen(onProductClick = { product ->
                navController.currentBackStackEntry?.savedStateHandle?.set("product", product)
                navController.navigate("product_detail")
            })
        }
        composable("product_detail") { backStackEntry ->
            // Retrieve the product from savedStateHandle
            val product = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Product>("product")
            ProductDetailScreen(product = product)
        }
    }
}
