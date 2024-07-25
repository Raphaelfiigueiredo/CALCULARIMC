package com.example.calcularimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edittext_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edittext_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_Calcular)

        btnCalcular.setOnClickListener {
            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                Snackbar.make(edtPeso, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            } else {
                try {
                    val peso = pesoStr.toFloat()
                    val altura = alturaStr.toFloat()

                    if (peso <= 0 || altura <= 0) {
                        Snackbar.make(edtPeso, "Valores inválidos", Snackbar.LENGTH_LONG).show()
                        return@setOnClickListener
                    }

                    val alturaQ2 = altura * altura
                    val resultado = peso / alturaQ2

                    val intent = Intent(this, ResultadoActivity::class.java).apply {
                        putExtra(KEY_RESULT_IMC, resultado)
                    }
                    startActivity(intent)

                    Log.d("MainActivity", "O resultado é $resultado")
                } catch (e: NumberFormatException) {
                    Snackbar.make(edtPeso, "Entradas inválidas", Snackbar.LENGTH_LONG).show()
                    Log.e("MainActivity", "Error parsing input: ${e.message}")
                }
            }
        }
    }
}
