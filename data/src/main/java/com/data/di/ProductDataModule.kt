package com.data.di

import com.data.repository.ProductRepositoryImpl
import com.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDataModule {

    @Binds
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository
}
