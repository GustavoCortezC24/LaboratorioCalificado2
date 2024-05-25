package com.cortez.gustavo.usolayoutsv4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val imageView: ImageView = findViewById(R.id.imageView)
        val btnShow: Button = findViewById(R.id.btnShow)
        val btnHide: Button = findViewById(R.id.btnHide)

        btnShow.setOnClickListener {
            imageView.visibility = View.VISIBLE
        }

        btnHide.setOnClickListener {
            imageView.visibility = View.GONE
        }
    }
}
