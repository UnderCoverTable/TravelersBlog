package com.example.travelersblog

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.databinding.ActivityS2RegisterScreenBinding
import java.io.File
import java.util.regex.Pattern

class S2RegisterScreen : AppCompatActivity() {
    private lateinit var binding: ActivityS2RegisterScreenBinding
    private lateinit var file: File
    private var userDb = mutableMapOf<String, MutableList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS2RegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        file = File(filesDir, "user-db.txt")
        if (!file.exists()) {
            file.createNewFile()
            file.appendText("kintama|||12345678|||sexy@gmail.com\n" +
                    "sameed|||12345678|||hot@gmail.com\n" +
                    "penis|||12345678|||penis@gmail.com\n")
        }
        loadData()

        binding.RegisterS2Button.setOnClickListener {
            var flag = 1
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextConfirmPassword.text.toString()
            val username = binding.editTextUsername.text.toString().trim()


            if (usernameExists(username)) {
                flag = 0
                //resetEditTexts()
                Toast.makeText(this, "Username already Exists", Toast.LENGTH_LONG).show()
                binding.editTextUsername.error = "Username already Exists"
            }

            else if (emailExists(username)) {
                flag = 0
                //resetEditTexts()
                Toast.makeText(this, "Email already Exists", Toast.LENGTH_LONG).show()
                binding.editTextEmail.error = "Email already Exists"
            }

            else if (password != confirmPassword) {
                flag = 0
                //resetPasswordEditTexts()
                Toast.makeText(this, "Password doesnt match", Toast.LENGTH_LONG).show()
                binding.editTextConfirmPassword.error = "Password doesnt match"

            }

           // if (password.length < 8) {
           //     resetPasswordEditTexts()
           //     TODO("Weak Password alert")
          //  }

            else if (!isValidEmail(email)) {
                flag = 0
                //resetEditTexts()
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show()
                binding.editTextEmail.error = "Invalid Email"
            }

            if (flag == 1) {
                val user = User(username = username, email = email, password = password)
                writeToFile(user)
                loadData()
                val intent = Intent(this, S1LoginScreen::class.java)
                startActivity(intent)
            }
        }

    }

    private fun resetPasswordEditTexts() {
        binding.editTextPassword.text = null
        binding.editTextConfirmPassword.text = null
    }

    private fun resetEditTexts() {
        binding.editTextEmail.text = null
        binding.editTextPassword.text = null
        binding.editTextConfirmPassword.text = null
        binding.editTextUsername.text = null
    }

    private fun isValidEmail(email: String): Boolean {
        var isValid = true
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }

    private fun usernameExists(username: String): Boolean {
        return userDb.containsKey(username)
    }

    private fun emailExists(email: String): Boolean {
        var exists = false
        userDb.forEach {
            if (it.value[1] == email) {
                exists = true
            }
        }
        return exists
    }

    private fun writeToFile(user: User) {
        file.appendText("${user.username}|||${user.password}|||${user.email}\n")
        loadData()
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