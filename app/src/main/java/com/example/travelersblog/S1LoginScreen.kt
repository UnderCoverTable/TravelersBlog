package com.example.travelersblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.travelersblog.databinding.ActivityMainBinding
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding
import java.io.File

class S1LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityS1LoginScreenBinding
    private val file = File(filesDir, "user-db.txt")
    private lateinit var userDb: MutableMap<String, MutableList<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS1LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        Log.d("FileExists", "user-db.txt exists: ${file.exists()}")
        loadData()

        binding.RegisterButton.setOnClickListener {
            val intent = Intent(this, S2RegisterScreen::class.java)
            startActivity(intent)
        }

        binding.LoginButton.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (validate(username = username, password = password)) {
                val intent = Intent(this, S3BlogEntries::class.java)
                intent.putExtra("guest", false)
                startActivity(intent)
            } else {
                TODO("Show an error message that credentials not found in records")
            }
        }

        binding.GuestButton.setOnClickListener {
            val intent = Intent(this, S3BlogEntries::class.java)
            intent.putExtra("guest", true)
            startActivity(intent)
        }

    }

    private fun validate(username: String, password: String): Boolean {
        var flag = false
        if (!userDb.containsKey(username)){
            return false
        }
        val userPassword = userDb[username]!![0]
        if (userPassword == password) {
            flag = true
        }
        return flag
    }

    private fun loadData() {
        val data = file.readText()
        data.split("\n").forEach {
            val temp = it.split(", ")
            if (!userDb.containsKey(temp[0])) {
                userDb[temp[0]] = mutableListOf(temp[1], temp[2])
            }
        }
    }
}
