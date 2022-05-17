package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.databinding.ActivityMainBinding
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding

class S1LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityS1LoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS1LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.RegisterButton.setOnClickListener{
            val intent = Intent(this,S2RegisterScreen::class.java)
            startActivity(intent)

        }

    }
}
