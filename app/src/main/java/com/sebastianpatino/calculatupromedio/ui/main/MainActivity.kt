package com.sebastianpatino.calculatupromedio.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sebastianpatino.calculatupromedio.databinding.ActivityMainBinding

/*
* Punto 1 practica 2
* */
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = mainBinding.root
        setContentView(view)

        val promObserver = Observer<Double> { prom ->
            mainBinding.infoPromTextView.text = "La nota final del curso es: " + prom.toString()
        }
        mainViewModel.prom.observe(this, promObserver)

        val errorObserver = Observer<Int> { error ->
            when (error) {
                1 -> {
                    mainBinding.note60TextInputLayout.error = "Nota no valida"
                }
                2 -> {
                    mainBinding.note7TextInputLayout.error = "Nota no valida"
                }
                3 -> {
                    mainBinding.note8TextInputLayout.error = "Nota no valida"
                }
                else -> {
                    mainBinding.note25TextInputLayout.error = "Nota no valida"
                }
            }

        }
        mainViewModel.error.observe(this, errorObserver)


        val no_errorObserver = Observer<Int> { noerror ->
            when (noerror) {
                1 -> {
                    mainBinding.note60TextInputLayout.error = null
                }
                2 -> {
                    mainBinding.note7TextInputLayout.error = null
                }
                3 -> {
                    mainBinding.note8TextInputLayout.error = null
                }
                else -> {
                    mainBinding.note25TextInputLayout.error = null
                }
            }
        }
        mainViewModel.noerror.observe(this, no_errorObserver)

        mainBinding.calculateButton.setOnClickListener {
            val numero1 = mainBinding.note60EditText.text.toString().toDoubleOrNull()
            val numero2 = mainBinding.note7EditText.text.toString().toDoubleOrNull()
            val numero3 = mainBinding.note8EditText.text.toString().toDoubleOrNull()
            val numero4 = mainBinding.note25EditText.text.toString().toDoubleOrNull()

            mainViewModel.prom(numero1,numero2,numero3,numero4)

        }
    }
}