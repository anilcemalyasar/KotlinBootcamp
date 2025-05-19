package com.example.odev7todoapp.data.repo

import com.example.odev7todoapp.data.datasource.TodoDataSource
import com.example.odev7todoapp.data.entity.Todo

class TodoRepository(var todoDataSource: TodoDataSource) {

    suspend fun addTodo(name: String, start_date: String, end_date: String)
        = todoDataSource.addTodo(name, start_date, end_date)

    suspend fun getAllTodos() : List<Todo> = todoDataSource.getAllTodos()

    suspend fun deleteTodo(id : Int) = todoDataSource.deleteTodo(id)

    suspend fun updateTodo(id: Int, name: String, start_date: String, end_date: String)
        = todoDataSource.updateTodo(id, name, start_date, end_date)

    suspend fun searchTodo(searchWord: String) = todoDataSource.searchTodo(searchWord)

}