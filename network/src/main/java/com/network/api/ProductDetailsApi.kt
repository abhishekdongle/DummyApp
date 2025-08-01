package com.network.api

import com.network.model.ProductDetailsDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductDetailsApi(private val client: HttpClient) {
    suspend fun getProductById(id: Int): ProductDetailsDto {
        return client.get("https://dummyjson.com/products/$id").body()
    }
}