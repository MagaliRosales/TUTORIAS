package com.example.tutorias

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tutorias.ui.setupNavigationMenu
import com.google.android.material.navigation.NavigationView

class reportes : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)

        drawerLayout = findViewById(R.id.drawerLayout)
        val iconMenu: ImageView = findViewById(R.id.iconMenu)
        val navView = findViewById<NavigationView>(R.id.navigationView)

        iconMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        setupNavigationMenu(this, drawerLayout, navView)
    }
}