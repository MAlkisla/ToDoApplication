package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.TodosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoDetailViewModel : ViewModel() {
    var todosRepository = TodosRepository()

    fun update(todo_id: Int, todo_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            todosRepository.update(todo_id, todo_name)
        }
    }
}