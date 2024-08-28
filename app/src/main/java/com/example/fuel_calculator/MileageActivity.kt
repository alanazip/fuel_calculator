package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MileageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mileage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button: Button = findViewById(R.id.button4)

        button.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val precoCombustivel = 1.70 // Substitua pelo valor real
            val consumoPorLitro = 5.0 // Substitua pelo valor real
            val quilometragem = 150.0 // Substitua pelo valor real
            intent.putExtra("precoCombustivel", precoCombustivel)
            intent.putExtra("consumoPorLitro", consumoPorLitro)
            intent.putExtra("quilometragem", quilometragem)
            startActivity(intent)
        }
    }
}