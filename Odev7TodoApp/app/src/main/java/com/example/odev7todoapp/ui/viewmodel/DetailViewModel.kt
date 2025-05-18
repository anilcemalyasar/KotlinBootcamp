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
class DetailViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {

    fun updateTodo(id: Int, name: String, start_date: String, end_date: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.updateTodo(id, name, start_date, end_date)
        }
    }
}