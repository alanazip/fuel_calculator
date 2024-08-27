package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
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

        // Configura o clique do botão para navegar para MainActivity
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}