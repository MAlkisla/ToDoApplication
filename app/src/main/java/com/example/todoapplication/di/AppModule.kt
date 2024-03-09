package com.example.todoapplication.di

import com.example.todoapplication.data.datasource.TodosDataSource
import com.example.todoapplication.data.repo.TodosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideTodosDataSource(): TodosDataSource {
        return TodosDataSource()
    }
}