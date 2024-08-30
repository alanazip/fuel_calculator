package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class CarConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_consumption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button: Button = findViewById(R.id.button3)


        // Captura o valor do campo de entrada
        val editTextConsumption: EditText = findViewById(R.id.consumoPorLitroEditText)

// Recebe o preço do combustível da FuelPriceActivity
        val fuelPrice = intent.getDoubleExtra("precoCombustivel", 0.0)

        button.setOnClickListener {
            val consumptionPerLiter = editTextConsumption.text.toString().toDoubleOrNull() ?: 0.0
            val intent = Intent(this, MileageActivity::class.java)
            // Passa o preço do combustível e o consumo por litro para a próxima atividade
            intent.putExtra("precoCombustivel", fuelPrice)
            intent.putExtra("consumoPorLitro", consumptionPerLiter)
            startActivity(intent)
        }
    }
}