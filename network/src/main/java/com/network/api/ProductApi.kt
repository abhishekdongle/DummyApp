package com.network.api

import com.network.model.ProductDto
import com.network.model.ProductResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductApi(private val client: HttpClient) {

    suspend fun getProducts(): ProductResponseDto {
        return client.get("https://dummyjson.com/products").body()
    }
}
