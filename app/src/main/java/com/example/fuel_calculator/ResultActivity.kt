package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.navigation.ui.AppBarConfiguration
import com.example.fuel_calculator.databinding.ActivityResultBinding
import java.text.DecimalFormat

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

        val consumo = quilometragem / consumoPorLitro
        val custoTotal = consumo * precoCombustivel

        val decimalFormat = DecimalFormat("#.##")
        val precoCombustivelFormatado = decimalFormat.format(precoCombustivel)
        val consumoPorLitroFormatado = decimalFormat.format(consumoPorLitro)
        val quilometragemFormatada = decimalFormat.format(quilometragem)
        val custoTotalFormatado = decimalFormat.format(custoTotal)

        findViewById<TextView>(R.id.textView10).text = "Preço do Combustível: R$$precoCombustivelFormatado"
        findViewById<TextView>(R.id.textView14).text = "Consumo por Litro: $consumoPorLitroFormatado L"
        findViewById<TextView>(R.id.textView15).text = "Quilometragem: $quilometragemFormatada Km"
        findViewById<TextView>(R.id.textView5).text = "Custo total: R$$custoTotalFormatado"

        val button: Button = findViewById(R.id.button6)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}