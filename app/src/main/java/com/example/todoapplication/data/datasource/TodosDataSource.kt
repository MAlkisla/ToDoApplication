package com.example.todoapplication.data.datasource

import android.util.Log
import com.example.todoapplication.data.entity.Todos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosDataSource {
    suspend fun add(todo_name: String) {
        Log.e("To-Do Add", "$todo_name")
    }

    suspend fun update(todo_id: Int, todo_name: String) {
        Log.e("To-Do Update", "$todo_id - $todo_name")
    }

    suspend fun delete(todo_id: Int) {
        Log.e("To-Do Delete", todo_id.toString())
    }

    suspend fun loadTodos(): List<Todos> = withContext(Dispatchers.IO) {

        val list = ArrayList<Todos>()

        val t1 = Todos(1, "empty")
        val t2 = Todos(2, "null")
        val t3 = Todos(3, "full")
        list.add(t1)
        list.add(t2)
        list.add(t3)

        return@withContext list
    }

    suspend fun search(searchWord: String): List<Todos> = withContext(Dispatchers.IO) {

        val list = ArrayList<Todos>()
        val t1 = Todos(1, "empty")
        list.add(t1)

        return@withContext list
    }
}