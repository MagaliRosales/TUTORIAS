package com.example.tutorias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
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

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)
        val etUsuario = findViewById<EditText>(R.id.etUsuario)

        btnAcceder.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()


            //VALIDAR POR EDITTEXT

            if (usuario.isNotEmpty()) {

                when (usuario) {
                    "2025004" -> {
                        startActivity(Intent(this, inicio_estudiante::class.java))
                        return@setOnClickListener
                    }
                    "tutor" -> {
                        startActivity(Intent(this, inicio_tutores::class.java))
                        return@setOnClickListener
                    }
                    "coordi" -> {
                        startActivity(Intent(this, coordi::class.java))
                        return@setOnClickListener
                    }
                    else -> {
                        Toast.makeText(this, "Usuario no válido", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
            }


            //  SI EL EDITTEXT ESTÁ VACÍO → VALIDAR RADIOS

            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Seleccione un tipo de usuario o escriba un usuario válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when (selectedId) {
                R.id.radioCoordinador -> startActivity(Intent(this, coordi::class.java))
                R.id.radioEstudiante -> startActivity(Intent(this, inicio_estudiante::class.java))
                R.id.radioTutor -> startActivity(Intent(this, inicio_tutores::class.java))
            }
        }
    }
}
