package com.example.anchorbookcondaggerhilt.di

import com.example.anchorbookcondaggerhilt.data.network.LibroApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// ESTOS SON OBJETOS Q SE CREAN PARA PODER INYECTAR ESTAS DEPENCENCIAS A TODA LA APP USANDO HILT


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun baseUrl(): String{
        return "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
    }

    @Provides
    @Singleton
    fun retrofit(baseUrl: String): Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun libroAPI(retrofit: Retrofit): LibroApiService{
        return retrofit.create(LibroApiService::class.java)
    }
}