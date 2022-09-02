package com.example.anchorbookcondaggerhilt.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anchorbookcondaggerhilt.data.model.retrofit.Libro

/*
 aqui definimos los elementos q iran en la tabla de base de datos (room,SQL) y el nombre de la tabla

*/
@Entity(tableName = "libros")
data class LibroDTO(
    @PrimaryKey override val id: Int,
    override val autor: String,
    override val pais: String,
    override val imagen: String,
    override val lenguaje: String,
    override val enlace: String?,
    override val paginas: Int?,
    override val titulo: String,
    override val anno: Int?,
    override val precio: Int?,
    override val ultimoPrecio: Int?,
    override val despacho: Boolean?
    ): Libro

