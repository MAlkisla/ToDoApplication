package com.example.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.data.entity.Todos

@Database(entities = [Todos::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getTodosDao(): TodosDao
}