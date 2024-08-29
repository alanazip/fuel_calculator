package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.navigation.ui.AppBarConfiguration
import com.example.fuel_calculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Recebe os valores passados da tela anterior
        val precoCombustivel = intent.getDoubleExtra("precoCombustivel", 0.0)
        val consumoPorLitro = intent.getDoubleExtra("consumoPorLitro", 0.0)
        val quilometragem = intent.getDoubleExtra("quilometragem", 0.0)

        // Calcula o consumo e o custo total
        val consumo = quilometragem / consumoPorLitro
        val custoTotal = consumo * precoCombustivel

        // Exibe os valores na tela
        findViewById<TextView>(R.id.textView10).text = "Preço do Combustível: $precoCombustivel"
        findViewById<TextView>(R.id.textView14).text = "Consumo por Litro: $consumoPorLitro"
        findViewById<TextView>(R.id.textView15).text = "Quilometragem: $quilometragem"
        findViewById<TextView>(R.id.textView5).text = "Custo total: $custoTotal"

        // Configura o botão para retornar à MainActivity
        val button: Button = findViewById(R.id.button6)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
