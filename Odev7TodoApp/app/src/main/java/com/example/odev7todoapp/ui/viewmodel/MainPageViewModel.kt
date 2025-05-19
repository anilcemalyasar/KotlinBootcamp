package com.example.odev7todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.data.repo.TodoRepository
import com.example.odev7todoapp.utils.convertDateToSqlFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel(){

    var todoList = MutableLiveData<List<Todo>>()

    // sayfa yüklendiğinde ilk olarak tüm todo ları çekeceğiz
    init {
        getAllTodos()
    }

    fun getAllTodos() {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoRepository.getAllTodos()
//            for (todo in todoList.value) {
//                todo.startDate =  todo.startDate.convertDateToSqlFormat(todo.startDate, "yyyy-MM-dd", "dd.MM.yyyy")
//                todo.endDate =  todo.endDate.convertDateToSqlFormat(todo.endDate, "yyyy-MM-dd", "dd.MM.yyyy")
//            }
        }
    }

    fun deleteTodo(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.deleteTodo(id)
            getAllTodos()
        }
    }

    fun searchTodo(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoRepository.searchTodo(searchWord)
        }
    }

}