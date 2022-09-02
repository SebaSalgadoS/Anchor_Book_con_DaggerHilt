package com.example.anchorbookcondaggerhilt.core.helper

import com.example.anchorbookcondaggerhilt.data.model.retrofit.LibroModel
import com.example.anchorbookcondaggerhilt.data.room.LibroDTO

class LibroHelper {

    companion object{

        fun emplyLibroDTO(): LibroDTO{
            return LibroDTO(
                0,
                "S/I",
                "S/I",
                "https://via.placeholder.com/140x100",
                "S/I",
                "S/I",
                0,
                "S/I",
                0,
                0,
                0,
                false

            )
        }

        fun emplyLibroModel(): LibroModel {
            return LibroModel(
                0,
                "S/I",
                "S/I",
                "https://via.placeholder.com/140x100",
                "S/I",
                "S/I",
                0,
                "S/I",
                0,
                0,
                0,
                false
            )
        }
    }
}