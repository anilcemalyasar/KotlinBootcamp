package com.example.odev7todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {

    fun addTodo(name: String, start_date: String, end_date: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.addTodo(name, start_date, end_date)
        }
    }
}