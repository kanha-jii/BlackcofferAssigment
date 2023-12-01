package com.example.blackcofferassigment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private var splashTimer: Timer? = null
    private val DELAY: Long = 1000
    private var scheduled = false
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll= findViewById<LottieAnimationView>(R.id.lottie_anim)
        ll.playAnimation()


        context = this
        splashTimer = Timer()

        splashTimer!!.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(context, HomeScreen::class.java)
                startActivity(intent)
                finishAfterTransition()
            }
        }, DELAY)
        scheduled = true

    }
}