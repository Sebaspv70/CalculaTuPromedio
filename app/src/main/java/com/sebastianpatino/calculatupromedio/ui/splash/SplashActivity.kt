package com.sebastianpatino.calculatupromedio.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebastianpatino.calculatupromedio.R
import com.sebastianpatino.calculatupromedio.databinding.ActivitySplashBinding
import com.sebastianpatino.calculatupromedio.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        /*Navegar entre actividades*/
        val timer = Timer()
        timer.schedule(
            timerTask {
            val intent = Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000
        )
    }
}