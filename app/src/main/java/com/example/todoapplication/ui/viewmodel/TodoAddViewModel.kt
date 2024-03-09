package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoAddViewModel @Inject constructor(var todosRepository: TodosRepository): ViewModel()  {
    fun add(todo_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            todosRepository.add(todo_name)
        }
    }
}