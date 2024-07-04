package com.example.findweather

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Constant for the splash screen delay duration
    companion object {
        private const val SPLASH_SCREEN_DELAY: Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delay for SPLASH_SCREEN_DELAY milliseconds before starting HomeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            // Finish MainActivity so that the user cannot return to it
            finish()
        }, SPLASH_SCREEN_DELAY)
    }
}
