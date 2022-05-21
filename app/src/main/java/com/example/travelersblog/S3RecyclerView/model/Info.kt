package com.example.travelersblog.S3RecyclerView.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Info (
    @DrawableRes val imageResourceId: Int,
    val place: String,
    val longDesc: String,
    val shortDesc: String,
    val author: String
)