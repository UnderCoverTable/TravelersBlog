package com.example.travelersblog.S3RecyclerView.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Info (
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringTitle: Int,
    @StringRes val stringDescription: Int,
    @StringRes val stringAuthor: Int
)