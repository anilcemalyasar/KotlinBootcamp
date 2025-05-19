package com.example.odev7todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.data.repo.TodoRepository
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