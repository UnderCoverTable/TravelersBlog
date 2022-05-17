package com.example.travelersblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.databinding.ActivityS5ImageListBinding
import com.example.travelersblog.S5RecyclerView.data.Datasource
import com.example.travelersblog.S5RecyclerView.adapter.ItemAdapter

class S5ImageList : AppCompatActivity() {
    private lateinit var binding: ActivityS5ImageListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS5ImageListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val myDataset = Datasource().loadImages()

        binding.imageRecyclerview.adapter = ItemAdapter(myDataset)
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

    }
}