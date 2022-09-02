package com.example.anchorbookcondaggerhilt.domain

import com.example.anchorbookcondaggerhilt.core.helper.LibroHelper
import com.example.anchorbookcondaggerhilt.core.mapper.LibroMapper
import com.example.anchorbookcondaggerhilt.data.model.retrofit.Libro
import com.example.anchorbookcondaggerhilt.data.network.LibroApiService
import com.example.anchorbookcondaggerhilt.data.room.LibroDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LibroRepository(val libroApi: LibroApiService, val libroDao: LibroDao) {

    suspend fun findById(id: Int): Libro {
        return withContext(Dispatchers.IO){
            val response =  libroApi.detalleLibro(id)
            if (response.isSuccessful){
                val libro = response.body() ?: LibroHelper.emplyLibroDTO()
                libroDao.insertAll(LibroMapper.toEntity(libro))
                libro
            }else{
                libroDao.findById(id)
            }
        }
    }

    suspend fun findAll(): List<Libro>{
        return withContext(Dispatchers.IO){
            val response = libroApi.listLibros()
            if (response.isSuccessful){
                val libros = response.body() ?: emptyList()
                libroDao.deleteAll()
                libros.forEach{ libroModel ->
                    libroDao.insertAll(LibroMapper.toEntity(libroModel))
                }
                libros
            }else{
                libroDao.getAll()
            }
        }
    }

}
