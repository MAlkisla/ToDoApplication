package com.example.todoapplication.data.datasource

import android.util.Log
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.room.TodosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosDataSource(private var todoDao: TodosDao) {
    suspend fun add(name: String) {
        val newTodo = Todos(0,name)
        todoDao.add(newTodo)
        //Log.e("To-Do Add", "$name")
    }

    suspend fun update(id: Int, name: String) {
        val updateTodo = Todos(id, name)
        todoDao.update(updateTodo)
        //Log.e("To-Do Update", "$id - $name")
    }

    suspend fun delete(id: Int) {
        val deleteTodo = Todos(id,"")
        todoDao.delete(deleteTodo)
        //Log.e("To-Do Delete", id.toString())
    }

    suspend fun loadTodos(): List<Todos> =
        withContext(Dispatchers.IO){
            return@withContext todoDao.loadTodos()
    }

    suspend fun search(searchWord: String): List<Todos> =
        withContext(Dispatchers.IO){
        return@withContext todoDao.search(searchWord)
    }

}