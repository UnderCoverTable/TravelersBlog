package com.example.travelersblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding

class S3BlogEntries : AppCompatActivity() {
    private lateinit var binding: ActivityS3BlogEntriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS3BlogEntriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}