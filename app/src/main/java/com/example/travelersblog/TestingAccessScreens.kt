package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding
import com.example.travelersblog.databinding.ActivityTestingAccessScreensBinding

class TestingAccessScreens : AppCompatActivity() {
    private lateinit var binding: ActivityTestingAccessScreensBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingAccessScreensBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button1.setOnClickListener{
            val intent = Intent(this,S1LoginScreen::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener{
            val intent = Intent(this,S2RegisterScreen::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener{
            val intent = Intent(this,S3BlogEntries::class.java)
            startActivity(intent)
        }
        binding.button4.setOnClickListener{
            val intent = Intent(this,S4NewEntry::class.java)
            startActivity(intent)
        }
        binding.button5.setOnClickListener{
            val intent = Intent(this,S5ImageList::class.java)
            startActivity(intent)
        }
        binding.button6.setOnClickListener{
            //val intent = Intent(this,S1LoginScreen::class.java)
            //startActivity(intent)
        }
    }


}