package com.example.travelersblog.S3RecyclerView.data

import android.content.Context
import android.util.Log
import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.S5RecyclerView.model.Images
import java.io.File

class DataSourceS3(private val context: Context) {
    private lateinit var file: File

    fun loadInfo(): MutableList<Info> {

        file = File(context.filesDir, "blog-db.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
//        file.appendText("fig001||Hunza||Beutifyl place hunza||hunza is a beautiful plca||Baig\n")
        val data = file.readText()
        val entries: MutableList<Info> = mutableListOf()

        if (data.isNotEmpty()){
            val splitData: MutableList<String> = data.split("\n") as MutableList<String>
            splitData.removeLast()

            splitData.forEach {
                val temp = it.split("||")
                entries.add(
                    Info(
                        imageResourceId = temp[0].toInt(), place = temp[1],
                        shortDesc = temp[2], longDesc = temp[3], author = temp[4]
                    )
                )
            }
        }

        return entries
    }
}
