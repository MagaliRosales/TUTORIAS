package com.example.tutorias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.example.tutorias.ui.setupNavigationMenu

class coordi : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordi)

        drawerLayout = findViewById(R.id.drawerLayout)
        val iconMenu: ImageView = findViewById(R.id.iconMenu)
        val navView = findViewById<NavigationView>(R.id.navigationView)

        // ABRIR MENÚ LATERAL
        iconMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        
        setupNavigationMenu(this, drawerLayout, navView)



        val btnRegTutores = findViewById<Button>(R.id.btnregtutores)
        btnRegTutores.setOnClickListener {
            val intent = Intent(this, regtutores::class.java)
            startActivity(intent)
        }


        val btnRegEstudiantes = findViewById<Button>(R.id.btnregestuduantes)
        btnRegEstudiantes.setOnClickListener {
            val intent = Intent(this, regestudiantes::class.java)
            startActivity(intent)
        }
    }
}
