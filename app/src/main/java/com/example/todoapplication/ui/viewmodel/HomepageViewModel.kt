package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(private var todosRepository: TodosRepository) : ViewModel() {
    var todosList = MutableLiveData<List<Todos>>()

    init {
        loadTodos()
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            todosRepository.delete(id)
            loadTodos()
        }
    }

    fun loadTodos() {
        CoroutineScope(Dispatchers.Main).launch {
            todosList.value = todosRepository.loadTodos()
        }
    }

    fun search(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todosList.value = todosRepository.search(searchWord)
        }
    }
}