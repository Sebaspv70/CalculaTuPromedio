package com.sebastianpatino.calculatupromedio.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {
    val prom: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val error: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val noerror: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun prom(num1: Double?, num2: Double?, num3: Double?, num4: Double?) {


        if (num1 != null && num1 in 0.0..5.0) {
            noerror.value = 1
            if (num2 != null && num2 in 0.0..5.0) {
                noerror.value = 2
                if (num3 != null && num3 in 0.0..5.0) {
                    noerror.value = 3
                    if (num4 != null && num4 in 0.0..5.0) {
                        noerror.value = 4
                        prom.value = ((num1 * 0.6 + num2 * 0.07 + num3 * 0.08 +
                                num4 * 0.25) * 100.0.roundToInt()) / 100.0
                    } else
                        error.value = 4
                } else
                    error.value = 3
            } else
                error.value = 2
        } else
            error.value = 1

    }

}