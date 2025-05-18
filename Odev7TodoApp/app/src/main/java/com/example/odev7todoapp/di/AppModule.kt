package com.example.odev7todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.odev7todoapp.data.datasource.TodoDataSource
import com.example.odev7todoapp.data.repo.TodoRepository
import com.example.odev7todoapp.room.AppDatabase
import com.example.odev7todoapp.room.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {

//        // veri tabanına erisim kodu
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "todo.sqlite"
        ).createFromAsset("todo.sqlite") // veri tabanını kopyalayacak
            .build()

        return db.getTodoDao()
    }




}