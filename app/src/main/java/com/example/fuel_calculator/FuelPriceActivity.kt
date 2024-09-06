package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class FuelPriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel_price)

        // Configuração de insets para ajustar o layout com barras de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia o botão 'button2' e o campo de texto de entrada 'precoCombustivelEditText'
        val button = findViewById<Button>(R.id.button2)
        val editTextFuelPrice: EditText = findViewById(R.id.precoCombustivelEditText)

        // Configura o clique do botão para ir para a próxima Activity
        button.setOnClickListener {
            val fuelPrice = editTextFuelPrice.text.toString().toDoubleOrNull() ?: 0.0 // Captura o preço do combustível
            val intent = Intent(this, CarConsumptionActivity::class.java) // Intenção de navegação para CarConsumptionActivity
            intent.putExtra("precoCombustivel", fuelPrice) // Passa o preço do combustível para a próxima atividade
            startActivity(intent) // Inicia a próxima Activity
        }
    }
}