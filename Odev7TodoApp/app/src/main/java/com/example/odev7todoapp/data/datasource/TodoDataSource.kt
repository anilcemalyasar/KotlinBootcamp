package com.example.odev7todoapp.data.datasource

import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var todoDao: TodoDao) {

    suspend fun addTodo(name: String, start_date: String, end_date: String) {
        todoDao.addTodo(Todo(0, name, start_date, end_date))
    }

    suspend fun getAllTodos() : List<Todo> = withContext(Dispatchers.IO) {
        return@withContext todoDao.getAllTodos()
    }
}