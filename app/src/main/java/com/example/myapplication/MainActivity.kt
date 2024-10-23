package com.example.myapplication

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var play: ImageButton = findViewById(R.id.play)
    var pause: ImageButton = findViewById(R.id.pause)
    var reset: ImageButton = findViewById(R.id.reset)
    var time: TextView = findViewById(R.id.time)
    var min: Int = 0
    var sec: Int = 0
    var hundSec: Int = 0
    var running: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.setOnClickListener {
            stopwatch()
        }
    }

    private fun stopwatch(){
        val handler: Handler = Handler(Looper.getMainLooper())
        var runner: Runnable = Runnable { }
        runner = Runnable {
            handler.postDelayed(runner, 100)
            hundSec++
            if (hundSec == 10){
                sec++
                hundSec = 0
            }
            if (sec == 60){
                min++
                sec = 0
            }
        }
        time.text = String.format("%02d", min) + "." + String.format("%02d", sec) + hundSec.toString()
    }
}