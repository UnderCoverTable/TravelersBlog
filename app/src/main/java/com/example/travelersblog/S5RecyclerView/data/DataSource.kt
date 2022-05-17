package com.example.travelersblog.S5RecyclerView.data

import com.example.travelersblog.R
import com.example.travelersblog.S5RecyclerView.model.Images

class Datasource() {
    fun loadImages(): List<Images> {
        return listOf<Images>(
            Images(R.drawable.fig001),
            Images(R.drawable.fig002),
            Images(R.drawable.fig003),
            Images(R.drawable.fig004),
            Images(R.drawable.fig005),
            Images(R.drawable.fig006),
            Images(R.drawable.fig007),
            Images(R.drawable.fig008),
            Images(R.drawable.fig009),
            Images(R.drawable.fig011),
            Images(R.drawable.fig012),
            Images(R.drawable.fig013),
            Images(R.drawable.fig014),
            Images(R.drawable.fig015),
            Images(R.drawable.fig016),
            Images(R.drawable.fig017),
            Images(R.drawable.fig018)
        )
    }
}
