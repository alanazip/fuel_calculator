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

        // Configura o layout para considerar insets de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Captura o valor de quilometragem do campo de entrada
        val editTextMileage: EditText = findViewById(R.id.quilometragemEditText)

        // Recebe os valores das atividades anteriores
        val fuelPrice = intent.getDoubleExtra("precoCombustivel", 0.0)
        val consumptionPerLiter = intent.getDoubleExtra("consumoPorLitro", 0.0)

        // Inicializa o botão e configura o clique
        val button: Button = findViewById(R.id.button4) // Certifique-se de que este ID está correto no XML
        button.setOnClickListener {
            val mileage = editTextMileage.text.toString().toDoubleOrNull() ?: 0.0
            val intent = Intent(this, ResultActivity::class.java)
            // Passa todos os valores para o ResultActivity
            intent.putExtra("precoCombustivel", fuelPrice)
            intent.putExtra("consumoPorLitro", consumptionPerLiter)
            intent.putExtra("quilometragem", mileage)
            startActivity(intent)
        }
    }
}