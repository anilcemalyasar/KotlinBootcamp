package com.example.finalproject.di

import com.example.finalproject.data.datasource.FoodDataSource
import com.example.finalproject.data.repo.FoodRepository
import com.example.finalproject.retrofit.ApiUtils
import com.example.finalproject.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFoodRepository(foodDataSource: FoodDataSource) : FoodRepository {
        return FoodRepository(foodDataSource)
    }

    @Provides
    @Singleton
    fun provideFoodDataSource(foodDao: FoodDao) : FoodDataSource {
        return FoodDataSource(foodDao)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao {
        return ApiUtils.getFoodDao()
    }
}