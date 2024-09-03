package com.example.fuel_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia o TextView do layout
        val textView = findViewById<TextView>(R.id.textView)

        // Referencia o Button do layout
        val button = findViewById<Button>(R.id.button)

        // Configura o botão para aumentar de tamanho e mudar de cor ao ser clicado
        button.setOnClickListener {
            button.scaleX = 1.1f // Aumenta o tamanho em 10% no eixo X
            button.scaleY = 1.1f // Aumenta o tamanho em 10% no eixo Y

            // Volta o tamanho ao normal após o clique
            button.postDelayed({
                button.scaleX = 1.0f
                button.scaleY = 1.0f
            }, 150) // Duração de 150 ms
            setContentView(R.layout.activity_fuel_price) // Certifique-se de que o layout 'activity_fuel_price' existe
        }
    }
}