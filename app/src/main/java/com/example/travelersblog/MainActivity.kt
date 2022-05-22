package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Logic for the splash screen
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,S1LoginScreen::class.java)
            startActivity(intent)
            finish()
        },500)
    }
}
