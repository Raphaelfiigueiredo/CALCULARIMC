package com.example.calcularimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar componentes EditText
        // Criar uma varíavel e associar o componente de UI <EditText>
        // Recuperar o botao da tela

        // Colocar acao no botao setOnclickListener
        // Recuperar o texto digitado no edt peso


        val edtpeso = findViewById<TextInputEditText>(R.id.edittext_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edittext_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_Calcular)


        btnCalcular.setOnClickListener {

            val intent = Intent(this,ResultadoActivity::class.java)



            val pesoStr: String = edtpeso.text.toString()
            val alturaStr: String = edtaltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                // Mostrar mensagem para o usuario

                Snackbar.make(
                    edtpeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {


                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()


                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                intent.putExtra("peso",peso.toDouble())


                println("Raphael Acao do botao" + resultado)
            }

            startActivity(intent)


        }
    }
}

