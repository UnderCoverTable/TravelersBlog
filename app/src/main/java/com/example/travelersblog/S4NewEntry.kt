package com.example.travelersblog

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.travelersblog.databinding.ActivityS1LoginScreenBinding
import com.example.travelersblog.databinding.ActivityS4NewEntryBinding

class S4NewEntry : AppCompatActivity() {
    private lateinit var binding: ActivityS4NewEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS4NewEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.imageListButton.setOnClickListener{
            val intent = Intent(this,S5ImageList::class.java)
            startActivity(intent)
        }
        if(S5ImageList.imageID != 0){
            findImageName(S5ImageList.imageID)
            var pic_str : String = "Pic: "
            binding.picName.text = pic_str.plus(" ").plus(S5ImageList.imageName)

        }
    }
}

fun findImageName(id:Int){
    when(id){
        R.drawable.fig001-> S5ImageList.imageName = "fig001"
        R.drawable.fig002-> S5ImageList.imageName = "fig002"
        R.drawable.fig003-> S5ImageList.imageName = "fig003"
        R.drawable.fig004-> S5ImageList.imageName = "fig004"
        R.drawable.fig005-> S5ImageList.imageName = "fig005"
        R.drawable.fig006-> S5ImageList.imageName = "fig006"
        R.drawable.fig007-> S5ImageList.imageName = "fig007"
        R.drawable.fig008-> S5ImageList.imageName = "fig008"
        R.drawable.fig009-> S5ImageList.imageName = "fig009"
        R.drawable.fig010-> S5ImageList.imageName = "fig010"
        R.drawable.fig011-> S5ImageList.imageName = "fig011"
        R.drawable.fig012-> S5ImageList.imageName = "fig012"
        R.drawable.fig013-> S5ImageList.imageName = "fig013"
        R.drawable.fig014-> S5ImageList.imageName = "fig014"
        R.drawable.fig015-> S5ImageList.imageName = "fig015"
        R.drawable.fig016-> S5ImageList.imageName = "fig016"
        R.drawable.fig017-> S5ImageList.imageName = "fig017"
        R.drawable.fig018-> S5ImageList.imageName = "fig018"
    }

}