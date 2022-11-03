package com.example.anchorbookcondaggerhilt.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchorbookcondaggerhilt.R
import com.example.anchorbookcondaggerhilt.data.model.adapter.LibroAdapter
import com.example.anchorbookcondaggerhilt.databinding.ActivityMainBinding
import com.example.anchorbookcondaggerhilt.ui.viewmodel.LibroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val libroViewModel: LibroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RECYCLERVIEW
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        libroViewModel.cargarLibros()

        libroViewModel.libros.observe(this, Observer { libros ->
            binding.recyclerView.adapter = LibroAdapter(libros)
        })

    }
}