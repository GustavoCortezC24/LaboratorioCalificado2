package com.cortez.gustavo.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val btnRegistrar: Button = findViewById(R.id.btnRegistrar)
        val etNombres: EditText = findViewById(R.id.etNombres)
        val etApellidos: EditText = findViewById(R.id.etApellidos)
        val etNumero: EditText = findViewById(R.id.etNumero)
        val etDireccion: EditText = findViewById(R.id.etDireccion)

        btnRegistrar.setOnClickListener {
            val nombres = etNombres.text.toString()
            val apellidos = etApellidos.text.toString()
            val numero = etNumero.text.toString()
            val direccion = etDireccion.text.toString()

            if (nombres.isEmpty() || apellidos.isEmpty() || numero.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ContactoGuardado::class.java)
                intent.putExtra("nombres", nombres)
                intent.putExtra("apellidos", apellidos)
                intent.putExtra("numero", numero)
                intent.putExtra("direccion", direccion)
                startActivity(intent)
            }
        }
    }
}