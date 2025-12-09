package com.example.tutorias.ui

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tutorias.MainActivity
import com.google.android.material.navigation.NavigationView
import com.example.tutorias.R
import com.example.tutorias.calendario
import com.example.tutorias.coordi
import com.example.tutorias.documentos
import com.example.tutorias.registros
import com.example.tutorias.reportes

fun setupNavigationMenu(
    activity: Activity,
    drawerLayout: DrawerLayout,
    navView: NavigationView
) {
    navView.setNavigationItemSelectedListener {

        when (it.itemId) {

            // INICIO → pantalla del coordinador
            R.id.nav_inicio -> {
                val intent = Intent(activity, coordi::class.java)
                activity.startActivity(intent)
            }

            // REGISTROS → cámbialo por tu Activity de registros
            R.id.nav_registros -> {
                val intent = Intent(activity, registros::class.java)
                activity.startActivity(intent)
            }

            // DOCUMENTOS → cámbialo por tu Activity de documentos
            R.id.nav_documentos -> {
                val intent = Intent(activity, documentos::class.java)
                activity.startActivity(intent)
            }

            // CALENDARIOS → cámbialo por tu Activity de calendario
            R.id.nav_calendarios -> {
                val intent = Intent(activity, calendario::class.java)
                activity.startActivity(intent)
            }

            // REPORTES → cámbialo por tu Activity de reportes
            R.id.nav_constancias -> {
                val intent = Intent(activity, reportes::class.java)
                activity.startActivity(intent)
            }

            // CERRAR SESIÓN → vuelve a MainActivity y limpia la pila
            R.id.nav_cerrar_sesion -> {
                Toast.makeText(activity, "Cerrando sesión...", Toast.LENGTH_SHORT).show()

                val intent = Intent(activity, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                activity.startActivity(intent)
                activity.finish()
            }
        }

        drawerLayout.closeDrawers()
        true
    }
}
