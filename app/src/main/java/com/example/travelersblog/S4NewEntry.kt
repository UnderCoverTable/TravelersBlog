package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding
import com.example.travelersblog.databinding.ActivityS4NewEntryBinding

class S4NewEntry : AppCompatActivity() {
    private lateinit var binding: ActivityS4NewEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS4NewEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.imageListButton.setOnClickListener{
            val intent = Intent(this,S5ImageList::class.java)
            startActivity(intent)
        }

    }
}