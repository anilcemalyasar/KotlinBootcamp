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

    suspend fun deleteTodo(id: Int) {
        todoDao.deleteTodo(Todo(id, "todo", "todo", "todo"))
    }

    suspend fun updateTodo(id: Int, name: String, start_date: String, end_date: String) {
        todoDao.updateTodo(Todo(id, name, start_date, end_date))
    }

    suspend fun searchTodo(searchWord : String) : List<Todo> = withContext(Dispatchers.IO) {
        todoDao.searchTodo(searchWord)
    }
}