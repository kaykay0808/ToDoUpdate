package com.example.todoupdate.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoupdate.data.models.TaskData

@Database(entities = [TaskData::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}