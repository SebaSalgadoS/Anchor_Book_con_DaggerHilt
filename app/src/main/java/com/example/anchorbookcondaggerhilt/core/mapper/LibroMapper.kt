package com.example.anchorbookcondaggerhilt.core.mapper

import com.example.anchorbookcondaggerhilt.data.model.retrofit.Libro
import com.example.anchorbookcondaggerhilt.data.room.LibroDTO

class LibroMapper {

    companion object{

        fun toEntity(libro: Libro): LibroDTO{
            with(libro){
                return LibroDTO(id, autor, pais, imagen, lenguaje, enlace, paginas, titulo, anno, precio, ultimoPrecio, despacho)
            }
        }
    }
}