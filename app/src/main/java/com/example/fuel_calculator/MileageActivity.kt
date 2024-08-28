package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class MileageActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {}

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MileageActivity> {
        override fun createFromParcel(parcel: Parcel): MileageActivity {
            return MileageActivity(parcel)
        }

        override fun newArray(size: Int): Array<MileageActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mileage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recebe os valores passados pela FuelPriceActivity
        val precoCombustivel = intent.getDoubleExtra("precoCombustivel", 0.0)
        val consumoPorLitro = intent.getDoubleExtra("consumoPorLitro", 0.0)
        val quilometragem = intent.getDoubleExtra("quilometragem", 0.0)

        // Configura o botão
        val button: Button = findViewById(R.id.button4)
        button.setOnClickListener {
            // Cria o intent para passar os dados para a próxima atividade
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("precoCombustivel", precoCombustivel)
            intent.putExtra("consumoPorLitro", consumoPorLitro)
            intent.putExtra("quilometragem", quilometragem)
            startActivity(intent)
        }
    }
}