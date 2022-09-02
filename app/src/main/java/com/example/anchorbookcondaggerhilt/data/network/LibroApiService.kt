package com.example.anchorbookcondaggerhilt.data.network

import com.example.anchorbookcondaggerhilt.data.model.retrofit.LibroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LibroApiService {

    @GET("books")
    suspend fun listLibros(): Response<List<LibroModel>>

    @GET("booksDetail/{id}")
    suspend fun detalleLibro(@Path("id") libroId: Int): Response<LibroModel>
}