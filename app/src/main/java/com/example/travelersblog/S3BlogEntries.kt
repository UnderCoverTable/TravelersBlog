package com.example.travelersblog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelersblog.S3RecyclerView.adapter.ItemAdapter_s3
import com.example.travelersblog.S3RecyclerView.data.DataSource_s3
import com.example.travelersblog.S5RecyclerView.adapter.ItemAdapter
import com.example.travelersblog.S5RecyclerView.data.Datasource
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding

class S3BlogEntries : AppCompatActivity() {
    private lateinit var binding: ActivityS3BlogEntriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS3BlogEntriesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val myDataset = DataSource_s3(this).loadInfo()
        binding.s3RecyclerView.adapter = ItemAdapter_s3(myDataset)

        val guest: Boolean = intent.getBooleanExtra("guest", true)

        //if (guest) {
       //     TODO("Show guest view with Logout & New button disabled")
        //}else {
        //    TODO("Normal view for logged in User")
       // }

    }
}