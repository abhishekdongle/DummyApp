package com.data.product.di

import com.data.product.repository.ProductDetailsRepositoryImpl
import com.data.product.repository.ProductRepositoryImpl
import com.domain.product.repository.ProductDetailsRepository
import com.domain.product.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDataModule {

    @Binds
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @Binds
    abstract fun bindProductDetailsRepository(impl: ProductDetailsRepositoryImpl): ProductDetailsRepository
}
