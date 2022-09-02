package com.example.anchorbookcondaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.example.anchorbookcondaggerhilt.data.room.DataBase
import com.example.anchorbookcondaggerhilt.data.room.LibroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BdModule {


    @Provides
    @Singleton
    fun baseDatos(@ApplicationContext appContext:Context): DataBase {
        return Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            "libros-db"
        ).build()
    }


    fun libroDao(baseDatos: DataBase): LibroDao{
        return baseDatos.libroDao()
    }
}