package com.example.travelersblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.databinding.ActivityS2RegisterScreenBinding
import java.io.File
import java.util.regex.Pattern

class S2RegisterScreen : AppCompatActivity() {
    private lateinit var binding: ActivityS2RegisterScreenBinding
    private val file = File("user-db.txt")
    private lateinit var userDb: MutableMap<String, MutableList<String>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS2RegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        loadData()
        file.createNewFile()

        binding.LoginButton.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextConfirmPassword.text.toString()
            val username = binding.editTextUsername.text.toString().trim()

            if (usernameExists(username)) {
                resetEditTexts()
                TODO("Username already exists alert (dialog box?)")
            }

            if (emailExists(username)) {
                resetEditTexts()
                TODO("Email already exists (dialog box?)")
            }

            if (password != confirmPassword) {
                resetPasswordEditTexts()
                TODO("Passwords don't match alert")
            }

            if (password.length < 8) {
                resetPasswordEditTexts()
                TODO("Weak Password alert")
            }

            if (!isValidEmail(email)) {
                resetEditTexts()
                TODO("Invalid email alert (dialog box?)")
            }

            val user = User(username = username, email = email, password = password)
            writeToFile(user)
            loadData()
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
        file.appendText("${user.username}, ${user.password}, ${user.email}\n")
    }

    private fun loadData() {
        val data = file.readText()
        data.split("\n").forEach {
            val temp = it.split(", ")
            if (!userDb.containsKey(temp[0])){
                userDb[temp[0]] = mutableListOf(temp[1], temp[2])
            }
        }
    }
}