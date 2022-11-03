package com.example.anchorbookcondaggerhilt.data.model.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anchorbookcondaggerhilt.R
import com.example.anchorbookcondaggerhilt.data.model.retrofit.Libro
import com.example.anchorbookcondaggerhilt.ui.view.DetalleLibro
import com.squareup.picasso.Picasso


// constante q guarda la ruta del package del proyecto

const val LIBROID_MENSSAGE = "com.example.anchorbookcondaggerhilt.LIBROID"

class LibroAdapter(private val datos: List<Libro>): RecyclerView.Adapter<LibroAdapter.ViewHolder>() {


    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val txtAutor: TextView
        val imageView: ImageView
        val txtTitulo: TextView
        val txtPais: TextView
        val txtYear: TextView
        val txtLenguaje: TextView

        init {
            txtAutor = view.findViewById(R.id.txtAutor)
            imageView = view.findViewById(R.id.imageView)
            txtTitulo = view.findViewById(R.id.txtTitulo)
            txtPais = view.findViewById(R.id.txtPais)
            txtYear = view.findViewById(R.id.txtYear)
            txtLenguaje = view.findViewById(R.id.txtLenguaje)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_libro, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = datos.get(position)

        holder.txtTitulo.text = "Titulo: ${libro.titulo}"
        holder.txtAutor.text = "Autor: ${libro.autor}"
        holder.txtLenguaje.text = "Lenguaje: ${libro.lenguaje}"
        holder.txtPais.text = "Pais: ${libro.pais}"
        holder.txtYear.text = "Año: ${libro.anno}"

        Picasso.get().load(libro.imagen).into(holder.imageView)

        // funcion click en cada tarjeta
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetalleLibro::class.java).apply{
                putExtra(LIBROID_MENSSAGE, libro.id)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}


