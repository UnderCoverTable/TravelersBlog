package com.example.travelersblog.S3RecyclerView.model

import androidx.annotation.DrawableRes

data class Info (
    @DrawableRes val imageResourceId: Int,
    val place: String,
    val shortDesc: String,
    val author: String,
    val longDesc: String
)