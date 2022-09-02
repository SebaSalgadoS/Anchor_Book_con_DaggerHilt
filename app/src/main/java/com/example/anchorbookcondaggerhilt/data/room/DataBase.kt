package com.example.anchorbookcondaggerhilt.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LibroDTO::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun libroDao(): LibroDao
}