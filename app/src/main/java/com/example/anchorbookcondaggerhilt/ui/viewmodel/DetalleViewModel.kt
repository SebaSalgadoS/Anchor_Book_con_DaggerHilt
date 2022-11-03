package com.example.anchorbookcondaggerhilt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anchorbookcondaggerhilt.data.model.retrofit.Libro
import com.example.anchorbookcondaggerhilt.domain.LibroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalleViewModel @Inject constructor(val repo: LibroRepository): ViewModel() {

    val libro = MutableLiveData<Libro>()

    fun cargarLibro(id:Int) {
        viewModelScope.launch {
            val libroFromRepo = repo.findById(id)
            if( libroFromRepo != null ) {
                libro.postValue(libroFromRepo)
            }
        }
    }
}