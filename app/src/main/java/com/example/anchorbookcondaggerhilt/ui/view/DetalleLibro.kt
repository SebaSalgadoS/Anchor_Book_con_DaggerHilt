package com.example.anchorbookcondaggerhilt.ui.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.anchorbookcondaggerhilt.R
import com.example.anchorbookcondaggerhilt.data.model.adapter.LIBROID_MENSSAGE
import com.example.anchorbookcondaggerhilt.databinding.ActivityDetalleLibroBinding
import com.example.anchorbookcondaggerhilt.ui.viewmodel.DetalleViewModel
import com.example.anchorbookcondaggerhilt.ui.viewmodel.LibroViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalleLibro : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleLibroBinding

    private val libroDetalleViewModel: DetalleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_libro)

        val libroid = intent.getIntExtra(
            LIBROID_MENSSAGE, 0)

        // le delegamos la responsabilidad al ViewModel
        // para cargar los datos del libro
        libroDetalleViewModel.cargarLibro(libroid)

        libroDetalleViewModel.libro.observe(this, Observer { libro ->
            with(binding) {
                detalleTitulo.text = libro.titulo
                detalleAutor.text = libro.autor
                detallePrecio.text = "${libro.precio}"
                Picasso.get().load(libro.imagen).into(detalleImagen)
            }

            // evento boton comprar
            binding.btnComprar.setOnClickListener {
                val textoCorreo = """
                Hola, 
                    
                Vi el libro ${libro.titulo} de código ${libro.id} y me gustaría que me 
                contactaran a este correo o al siguiente número telefónico ___________.
                
                Quedo atent@
                """.trimIndent()

                val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                    type = "msage/rfc822" // fix para que funcione PARA (TO)
                    data = Uri.parse("mailto:")
                    val para:Array<String> = arrayOf("ventas@anchorbook.cl")

                    putExtra(Intent.EXTRA_EMAIL, para)
                    putExtra(Intent.EXTRA_SUBJECT, "Consulta por libro ${libro.titulo} de código ${libro.id}")
                    putExtra(Intent.EXTRA_TEXT, textoCorreo)
                }

                startActivity(intentMail)
            }
            // END evento boton comprar
        })

    }
}