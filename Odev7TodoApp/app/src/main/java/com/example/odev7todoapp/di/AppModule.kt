package com.example.odev7todoapp.di

import com.example.odev7todoapp.data.datasource.TodoDataSource
import com.example.odev7todoapp.data.repo.TodoRepository
import com.example.odev7todoapp.room.TodoDao
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
    fun provideTodoRepository(todoDataSource: TodoDataSource) : TodoRepository {
        return TodoRepository(todoDataSource)
    }

    @Provides
    @Singleton
    fun provideTodoDataSource(todoDao: TodoDao) : TodoDataSource {
        return TodoDataSource(todoDao)
    }

    


}