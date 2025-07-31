package com.network.di

import com.network.api.ProductApi
import com.network.ktor.KtorClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKtorClient(): HttpClient = KtorClientProvider.client

    @Provides
    @Singleton
    fun provideProductApi(client: HttpClient): ProductApi = ProductApi(client)
}
