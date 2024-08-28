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
        // Localize o botão no layout
        val button: Button = findViewById(R.id.button6)
        button.setOnClickListener {
            val precoCombustivel = 1.70 // Substitua pelo valor real
            val consumoPorLitro = 5.0 // Substitua pelo valor real
            val quilometragem = 150.0 // Substitua pelo valor real
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("precoCombustivel", precoCombustivel)
            intent.putExtra("consumoPorLitro", consumoPorLitro)
            intent.putExtra("quilometragem", quilometragem)
            startActivity(intent)
        }

        // Configura o clique do botão para navegar para MainActivity
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        val precoCombustivel = intent.getDoubleExtra("precoCombustivel", 0.0)
        val consumoPorLitro = intent.getDoubleExtra("consumoPorLitro", 0.0)
        val quilometragem = intent.getDoubleExtra("quilometragem", 0.0)
        val consumo = quilometragem / consumoPorLitro
        val custoTotal = consumo * precoCombustivel
        findViewById<TextView>(R.id.textView5).text = "Custo total: $custoTotal"
    }
}