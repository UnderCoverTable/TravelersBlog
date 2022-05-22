package com.example.travelersblog

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.databinding.ActivityS4NewEntryBinding
import java.io.File

class S4NewEntry : AppCompatActivity() {
    private lateinit var binding: ActivityS4NewEntryBinding
    private lateinit var file : File
    private var blogDb = mutableMapOf<String, MutableList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS4NewEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        file = File(filesDir, "blog-db.txt")
        file.createNewFile()
        loadData()

        supportActionBar?.hide()

        binding.imageListButton.setOnClickListener {
            val intent = Intent(this, S5ImageList::class.java)
            startActivity(intent)
        }

        if (S5ImageList.imageID != 0) {
            findImageName(S5ImageList.imageID)
            val picStr = "Pic: "
            binding.picName.text = picStr.plus(" ").plus(S5ImageList.imageName)

        }

        binding.saveButton.setOnClickListener {
            val imageId = S5ImageList.imageID.toString()
            val place = binding.editTextPlace.text.toString()
            val shortDesc = binding.editTextShortdesc.text.toString()
            val longDesc = binding.editTextLongdesc.text.toString()
            val author = binding.author.text.toString()
            saveEntry(imageId = imageId, place = place, shortDesc = shortDesc, longDesc = longDesc, author = author)
            resetViews()
        }

    }

    private fun resetViews() {
        S5ImageList.imageID = 0
        binding.editTextLongdesc.text = null
        binding.editTextShortdesc.text = null
        binding.editTextPlace.text = null
    }

    private fun saveEntry(imageId: String, place: String, shortDesc: String, longDesc: String = " ", author: String) {
        file.appendText("${imageId}||${place}||${shortDesc}||${longDesc}||${author}\n")
    }

    private fun loadData() {
        val data = file.readText()
        if (data.isNotEmpty()){
            data.split("\n").forEach {
                val temp = it.split("||")
                if (!blogDb.containsKey(temp[0] + "||" + temp[1])) {
                    blogDb[temp[0] + "||" + temp[1]] = mutableListOf(temp[2], temp[3], temp[4])
                }
            }
        }
    }
}

fun findImageName(id: Int) {
    when (id) {
        R.drawable.fig001 -> S5ImageList.imageName = "fig001"
        R.drawable.fig002 -> S5ImageList.imageName = "fig002"
        R.drawable.fig003 -> S5ImageList.imageName = "fig003"
        R.drawable.fig004 -> S5ImageList.imageName = "fig004"
        R.drawable.fig005 -> S5ImageList.imageName = "fig005"
        R.drawable.fig006 -> S5ImageList.imageName = "fig006"
        R.drawable.fig007 -> S5ImageList.imageName = "fig007"
        R.drawable.fig008 -> S5ImageList.imageName = "fig008"
        R.drawable.fig009 -> S5ImageList.imageName = "fig009"
        R.drawable.fig010 -> S5ImageList.imageName = "fig010"
        R.drawable.fig011 -> S5ImageList.imageName = "fig011"
        R.drawable.fig012 -> S5ImageList.imageName = "fig012"
        R.drawable.fig013 -> S5ImageList.imageName = "fig013"
        R.drawable.fig014 -> S5ImageList.imageName = "fig014"
        R.drawable.fig015 -> S5ImageList.imageName = "fig015"
        R.drawable.fig016 -> S5ImageList.imageName = "fig016"
        R.drawable.fig017 -> S5ImageList.imageName = "fig017"
        R.drawable.fig018 -> S5ImageList.imageName = "fig018"
    }
}