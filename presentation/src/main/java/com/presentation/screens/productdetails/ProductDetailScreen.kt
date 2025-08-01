package com.presentation.screens.productdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.domain.product.models.Product
import com.domain.product.models.ProductDetails
import com.presentation.components.ErrorView
import com.presentation.components.HeaderComponent
import com.presentation.components.ImageCarousel
import com.presentation.components.LoadingView
import com.presentation.states.ProductDetailsUiState

@Composable
fun ProductDetailScreen(
    product: Product?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    val uiState by productDetailViewModel.uiState.collectAsState()

    Column {
        HeaderComponent("Product Details")
        when (uiState) {
            is ProductDetailsUiState.Loading -> {
                LoadingView()
            }

            is ProductDetailsUiState.Success -> {
                val productDetail = (uiState as ProductDetailsUiState.Success).products
                ProductDetailView(productDetail, product?.thumbnail)
            }

            is ProductDetailsUiState.Error -> {
                val errorMessage = (uiState as ProductDetailsUiState.Error).message
                ErrorView(errorMessage = errorMessage)
            }
        }
    }
    productDetailViewModel.onAction(product?.id)
}
//
//@Composable
//private fun ProductDetailView(product: ProductDetails, thumbnail: String?) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        AsyncImage(
//            model = thumbnail,
//            contentDescription = product.title,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .background(Color.LightGray)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = product.title.orEmpty(),
//            style = MaterialTheme.typography.headlineMedium,
//            maxLines = 2,
//            overflow = TextOverflow.Ellipsis
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = product.description.orEmpty(),
//            style = MaterialTheme.typography.bodyLarge,
//            maxLines = 4,
//            overflow = TextOverflow.Ellipsis
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        LazyRow(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            val images = product.images
//            images?.let {
//                items(it) { image ->
//                    AsyncImage(
//                        model = image,
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(100.dp)
//                            .background(Color.LightGray)
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
private fun ProductDetailView(product: ProductDetails, thumbnail: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        val images = product.images ?: listOfNotNull(thumbnail)
        if (images.isNotEmpty()) {
            ImageCarousel(images)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = product.title.orEmpty(),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.description.orEmpty(),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        product.rating?.let { rating ->
            Text(
                text = "Rating: %.1f / 5.0".format(rating),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Text(
            text = "Category: ${product.category.orEmpty()}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Price: $${product.price ?: "N/A"}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
