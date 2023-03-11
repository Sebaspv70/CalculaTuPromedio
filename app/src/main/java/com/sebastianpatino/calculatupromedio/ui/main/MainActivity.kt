package com.sebastianpatino.calculatupromedio.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sebastianpatino.calculatupromedio.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)



        mainBinding.calculateButton.setOnClickListener {
            val numero1 = if(mainBinding.note60EditText.text.toString().toDouble() !in 0.0..5.0) {
                mainBinding.note60TextInputLayout .error = "Nota no valida"
                0.0
            } else
                mainBinding.note60EditText.text.toString().toDouble()
            val numero2 = if(mainBinding.note7EditText.text.toString() == "") {
                0.0
            } else
                mainBinding.note7EditText.text.toString().toDouble()
            val numero3 = if(mainBinding.note8EditText.text.toString() == "") {
                0.0
            } else
                mainBinding.note8EditText.text.toString().toDouble()
            val numero4 = if(mainBinding.note25EditText.text.toString() == "") {
                0.0
            } else
                mainBinding.note25EditText.text.toString().toDouble()
            val prom = (numero1 * 0.6 + numero2 * 0.07 + numero3 * 0.08 + numero4 * 0.25)*100.0.roundToInt()/100.0
            val info = "La nota final del curso es: $prom"

            if (numero1 in 0.0..5.0) {
                mainBinding.note60TextInputLayout.error=null
                if (numero2 in 0.0..5.0) {
                    mainBinding.note7TextInputLayout.error=null
                    if (numero3 in 0.0..5.0) {
                        mainBinding.note8TextInputLayout.error=null
                        if (numero4 in 0.0..5.0) {
                            mainBinding.note25TextInputLayout.error=null
                            mainBinding.infoPromTextView.setText(info)
                        }
                        else
                            mainBinding.note25TextInputLayout.error = "Nota no valida"
                    }
                    else
                        mainBinding.note8TextInputLayout.error = "Nota no valida"
                }
                else
                    mainBinding.note7TextInputLayout .error = "Nota no valida"
            }
            else
                mainBinding.note60TextInputLayout .error = "Nota no valida"

        }
    }
}