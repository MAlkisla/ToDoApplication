package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.TodosDataSource
import com.example.todoapplication.data.entity.Todos

class TodosRepository(private var todosDataSource: TodosDataSource) {
    suspend fun add(name: String) = todosDataSource.add(name)

    suspend fun update(id: Int, name: String) = todosDataSource.update(id, name)

    suspend fun delete(id: Int) = todosDataSource.delete(id)

    suspend fun loadTodos(): List<Todos> = todosDataSource.loadTodos()

    suspend fun search(searchWord: String): List<Todos> = todosDataSource.search(searchWord)
}