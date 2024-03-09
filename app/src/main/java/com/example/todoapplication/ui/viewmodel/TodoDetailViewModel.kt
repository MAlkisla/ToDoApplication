package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(var todosRepository: TodosRepository): ViewModel() {
    fun update(todo_id: Int, todo_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            todosRepository.update(todo_id, todo_name)
        }
    }
}