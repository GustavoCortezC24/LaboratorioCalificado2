package com.cortez.gustavo.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactoGuardado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto_guardado)

        val nombreCliente = intent.getStringExtra("nombres") + " " + intent.getStringExtra("apellidos")
        val numeroCliente = intent.getStringExtra("numero")
        val direccionCliente = intent.getStringExtra("direccion")

        val tvNombreCliente: TextView = findViewById(R.id.tvNombreCliente)
        val tvNumeroCliente: TextView = findViewById(R.id.tvNumeroCliente)
        val btnLlamar: Button = findViewById(R.id.btnLlamar)
        val btnWsp: Button = findViewById(R.id.btnWsp)
        val btnMaps: Button = findViewById(R.id.btnMaps)

        tvNombreCliente.text = nombreCliente
        tvNumeroCliente.text = numeroCliente

        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numeroCliente")
            startActivity(intent)
        }

        btnWsp.setOnClickListener {
            val packageManager = packageManager
            val uri = Uri.parse("smsto:$numeroCliente")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hola $nombreCliente")
            intent.setPackage("com.whatsapp")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // La aplicación de WhatsApp no está instalada en el dispositivo
                Toast.makeText(this, "WhatsApp no está instalado en este dispositivo", Toast.LENGTH_SHORT).show()
            }
        }


        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccionCliente"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
