package com.example.todoupdate.di

import android.content.Context
import androidx.room.Room
import com.example.todoupdate.data.ToDoDatabase
import com.example.todoupdate.data.repository.DataStoreRepository
import com.example.todoupdate.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ToDoModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()

    @Singleton
    @Provides
    fun provideDatastore(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)
}
