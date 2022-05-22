package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.travelersblog.S3RecyclerView.adapter.ItemAdapterS3
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding
import com.example.travelersblog.databinding.ActivityS6BlogPageBinding

class S6BlogPage : AppCompatActivity() {

    lateinit var binding: ActivityS6BlogPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS6BlogPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageView.setImageResource(ItemAdapterS3.s6Image)
        binding.s6Title.text = ItemAdapterS3.S6Title
        binding.s6ShortDesc.text = ItemAdapterS3.S6ShortDesc
        binding.s6Author.text = ItemAdapterS3.s6Author
        binding.s6LongDesc.text = ItemAdapterS3.s6LongDesc


        binding.s6UpdateButton.setOnClickListener {
            if(S1LoginScreen.isGuest == 1){
                Toast.makeText(this, "Guests cannot access", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, S4NewEntry::class.java)
                this.startActivity(intent)
            }
        }


    }
}