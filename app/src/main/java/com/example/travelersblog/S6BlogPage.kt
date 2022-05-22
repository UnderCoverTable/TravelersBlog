package com.example.travelersblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding
import com.example.travelersblog.databinding.ActivityS6BlogPageBinding

class S6BlogPage : AppCompatActivity() {

    lateinit var binding: ActivityS6BlogPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS6BlogPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()




    }
}