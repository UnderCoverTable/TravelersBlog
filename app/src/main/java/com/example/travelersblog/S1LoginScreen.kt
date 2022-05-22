package com.example.travelersblog

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travelersblog.databinding.ActivityMainBinding
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding
import java.io.File

class S1LoginScreen : AppCompatActivity() {
    private lateinit var file: File
    private lateinit var binding: ActivityS1LoginScreenBinding
    private var userDb = mutableMapOf<String, MutableList<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS1LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        file = File(filesDir, "user-db.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        loadData()

        binding.RegisterButton.setOnClickListener {
            val intent = Intent(this, S2RegisterScreen::class.java)
            startActivity(intent)
        }

        binding.LoginButton.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (validate(username = username, password = password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                Log.d(TAG,"DONE LOGIN")

                val intent = Intent(this, S3BlogEntries::class.java)
                intent.putExtra("guest", false)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()

                if(userDb.containsKey(username)){
                    binding.editTextPassword.error = "Wrong password"
                }
                else{
                    binding.editTextUsername.error = "Username does not exist"
                }
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
        if (data.isNotEmpty()) {
            val splitData: MutableList<String> = data.split("\n") as MutableList<String>
            splitData.removeLast()

            splitData.forEach {
                val temp = it.split("|||")
                if (!userDb.containsKey(temp[0])) {
                    userDb.put(temp[0], mutableListOf(temp[1], temp[2]))
                }
            }
        }
    }
}
