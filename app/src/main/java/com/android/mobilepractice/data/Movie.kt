package com.android.mobilepractice.data

import com.android.mobilepractice.R

data class Movie(
    var movieId: Int = 0,
    var title: String = "",
    var year: Int = 0,
    var photo: Int = R.drawable.movie_default_pic
)
