package com.example.odev7todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev7todoapp.data.entity.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM toDos")
    suspend fun getAllTodos() : List<Todo>

    @Insert
    suspend fun addTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)



}