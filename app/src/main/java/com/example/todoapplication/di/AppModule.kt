package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.datasource.TodosDataSource
import com.example.todoapplication.data.repo.TodosRepository
import com.example.todoapplication.room.Database
import com.example.todoapplication.room.TodosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodosRepository(todosDataSource: TodosDataSource): TodosRepository {
        return TodosRepository(todosDataSource)
    }

    @Provides
    @Singleton
    fun provideTodosDataSource(todosDao: TodosDao): TodosDataSource {
        return TodosDataSource(todosDao)
    }

    @Provides
    @Singleton
    fun provideTodosDao(@ApplicationContext context: Context) : TodosDao {
        val db = Room.databaseBuilder(context, Database::class.java,"toDos.sqlite")
            .createFromAsset("toDos.sqlite").build()
        return db.getTodosDao()
    }
}