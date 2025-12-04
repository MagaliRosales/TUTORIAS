package com.example.tutorias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)

        btnAcceder.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()

            when (usuario) {
                "coordi" -> {
                    startActivity(Intent(this, coordi::class.java))
                }
                "2025004" -> {
                    startActivity(Intent(this, inicio_estudiante::class.java))
                }

                else -> {
                    Toast.makeText(this, "Usuario no válido", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
