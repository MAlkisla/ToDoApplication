package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.TodosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoAddViewModel : ViewModel()  {
    var todosRepository = TodosRepository()

    fun add(todo_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            todosRepository.add(todo_name)
        }
    }
}