package com.network.api

import com.network.model.ProductDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductApi(private val client: HttpClient) {

    suspend fun getProducts(): List<ProductDto> {
        return client.get("https://dummyjson.com/docs/products").body()
    }
}
