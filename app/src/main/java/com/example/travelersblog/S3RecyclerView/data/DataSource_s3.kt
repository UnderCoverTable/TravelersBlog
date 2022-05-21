package com.example.travelersblog.S3RecyclerView.data

import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.S5RecyclerView.model.Images

class DataSource_s3() {

    fun loadInfo(): List<Info> {
        return listOf<Info>(
            info()
        )
    }
}
