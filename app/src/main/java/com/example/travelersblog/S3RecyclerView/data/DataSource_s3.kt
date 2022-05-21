package com.example.travelersblog.S3RecyclerView.data

import android.content.Context
import android.util.Log
import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.S5RecyclerView.model.Images
import java.io.File

class DataSource_s3(context: Context) {
    private val file = File(context.filesDir, "blog-db.txt")


    fun loadInfo(): MutableList<Info> {
        Log.d("FileExists", "blog-db.txt exists: ${file.exists()}")

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
