package com.example.gastodeviagem_pt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(),
    View.OnClickListener { //View.OnClickListener -> adicionado todo->2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)// id do botão todo->1
    }

    override fun onClick(v: View) {//todo->3
        val id = v.id
        if (id == R.id.buttonCalcular) {// Quando clicar no botão chama a função calcular
            calcular()
        }
    }

    private fun calcular() {//todo->4

        if (validacaoOK()) {//todo->5
            try {//todo->8
                val distancia = digitDistancia.text.toString().toFloat() // Pega o texto e converte para float
                val preco = digitPreco.text.toString().toFloat() // Pega o texto e converte para float
                val altonomia = digitAltonomia.text.toString().toFloat() // Pega o texto e converte para float

                val valorTotal = (distancia * preco) / altonomia

                textResultado.text = "R$ ${"%.2f".format(valorTotal)}"

            }catch (e: NumberFormatException){
                //Mensagem de erro caso algum parametro não for diferente de numero
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_SHORT).show()
            }

        }else{
            //Mensagem de erro caso algum parametro não for preenchido
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_SHORT).show()//todo->7
        }


    }

    private fun validacaoOK() : Boolean {//todo->6
        // Esse "return" é verdadeiro
        return (digitDistancia.text.toString() != ""
                && digitDistancia.text.toString() != "0"
                && digitPreco.text.toString() != ""
                && digitPreco.text.toString() != "0"
                && digitAltonomia.text.toString() != ""
                && digitAltonomia.text.toString() != "0")
    }
}