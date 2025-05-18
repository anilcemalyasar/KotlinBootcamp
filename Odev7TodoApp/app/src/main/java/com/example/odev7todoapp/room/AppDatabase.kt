package com.example.odev7todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.odev7todoapp.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao
}