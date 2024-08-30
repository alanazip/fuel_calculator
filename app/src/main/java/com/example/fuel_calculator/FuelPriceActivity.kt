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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button: Button = findViewById(R.id.button2)


        // Adicione esta linha para capturar o valor de entrada
        val editTextFuelPrice: EditText = findViewById(R.id.precoCombustivelEditText)

        button.setOnClickListener {
            val fuelPrice = editTextFuelPrice.text.toString().toDoubleOrNull() ?: 0.0
            val intent = Intent(this, CarConsumptionActivity::class.java)
            // Passa o preço do combustível para a próxima atividade
            intent.putExtra("precoCombustivel", fuelPrice)
            startActivity(intent)
        }
    }
}