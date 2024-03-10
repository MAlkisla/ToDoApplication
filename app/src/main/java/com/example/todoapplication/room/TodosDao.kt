package com.example.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapplication.data.entity.Todos

@Dao
interface TodosDao {
    @Query("SELECT * FROM toDos")
    suspend fun loadTodos(): List<Todos>

    @Insert
    suspend fun add(todos: Todos)

    @Update
    suspend fun update(todos: Todos)

    @Delete
    suspend fun delete(todos: Todos)

    @Query("SELECT * FROM toDos WHERE name like '%'||:searchWord ||'%'")
    suspend fun search(searchWord:String) : List<Todos>
}