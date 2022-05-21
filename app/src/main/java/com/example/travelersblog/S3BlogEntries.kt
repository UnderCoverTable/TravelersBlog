package com.example.travelersblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding

class S3BlogEntries: AppCompatActivity() {
    private lateinit var binding: ActivityS1LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS1LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}