package com.example.travelersblog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.S3RecyclerView.adapter.ItemAdapterS3
import com.example.travelersblog.S3RecyclerView.data.DataSourceS3
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding

class S3BlogEntries : AppCompatActivity() {
    private lateinit var binding: ActivityS3BlogEntriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS3BlogEntriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = DataSourceS3(this).loadInfo()
        binding.s3RecyclerView.adapter = ItemAdapterS3(myDataset)

        val guest: Boolean = intent.getBooleanExtra("guest", true)


        if (guest) {
            binding.s3NewBlogButton.setOnClickListener {
                Toast.makeText(this, "Please login to make new entry", Toast.LENGTH_LONG).show()
            }
            binding.s3LogoutButton.setOnClickListener {
                val intent = Intent(this, S1LoginScreen::class.java)
                startActivity(intent)
            }


        }else {
            binding.s3NewBlogButton.setOnClickListener {
                val intent = Intent(this, S4NewEntry::class.java)
                startActivity(intent)
            }
            binding.s3LogoutButton.setOnClickListener {
                val intent = Intent(this, S1LoginScreen::class.java)
                startActivity(intent)
            }
        }

    }
}