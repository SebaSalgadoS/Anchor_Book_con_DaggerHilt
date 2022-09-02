package com.example.anchorbookcondaggerhilt.data.room

import androidx.room.*

@Dao
interface LibroDao {

    @Query("SELECT * FROM libros")
    fun getAll() : List<LibroDTO>

    @Query("SELECT * FROM libros WHERE id = :lid")
    fun findById(lid: Int): LibroDTO

    @Query("DELETE FROM libros")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg libros: LibroDTO)

    @Delete
    fun delete(libro: LibroDTO)
}