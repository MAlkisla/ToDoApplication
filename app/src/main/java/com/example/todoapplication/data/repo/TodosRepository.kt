package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.TodosDataSource
import com.example.todoapplication.data.entity.Todos

class TodosRepository {
    var todosDataSource = TodosDataSource()

    suspend fun add(todo_name: String) = todosDataSource.add(todo_name)

    suspend fun update(todo_id: Int, todo_name: String) = todosDataSource.update(todo_id, todo_name)

    suspend fun delete(todo_id:Int) = todosDataSource.delete(todo_id)

    suspend fun loadTodos(): List<Todos> = todosDataSource.loadTodos()

    suspend fun search(searchWord: String): List<Todos> = todosDataSource.search(searchWord)
}