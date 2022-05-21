package com.example.travelersblog
import java.io.File

fun main(){
//    var data = User(username = "kintama48", email = "baigmono48@gmail.com", password = "123")
    val filename = "user-db.txt"
    val file = File(filename)

//    var isCreated = file.createNewFile()
//    file.appendText("\n")
//    file.appendText(data.toString())
    var data = file.readText().split("\n")
    var user = Class.forName("com.example.travelersblog.User")
    print(user)
}