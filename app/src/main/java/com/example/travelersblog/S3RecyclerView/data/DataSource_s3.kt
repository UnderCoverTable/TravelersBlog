package com.example.travelersblog.S3RecyclerView.data

import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.S5RecyclerView.model.Images
import java.io.File

class DataSource_s3() {

    private val file = File("blog-db.txt")


    fun loadInfo(): MutableList<Info> {
        val data = file.readText()
        val entries: MutableList<Info> = mutableListOf()

        data.split("\n").forEach {
            val temp = it.split("||")
            entries.add(Info(imageResourceId = temp[0].toInt(), place = temp[1],
                shortDesc = temp[2], longDesc = temp[3], author = temp[4]))
        }

        return entries
    }
}
