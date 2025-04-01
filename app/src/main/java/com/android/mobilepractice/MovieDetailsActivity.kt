package com.android.mobilepractice

import android.app.Activity
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetailsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        //Find ui elements
        val photo = findViewById<ImageView>(R.id.image_view_movieDetail_pic)
        val title = findViewById<TextView>(R.id.text_view_movieDetail_title)
        val id = findViewById<TextView>(R.id.text_view_movieDetail_id)
        val year = findViewById<TextView>(R.id.text_view_movieDetail_year)
        // Extract data from intent
        intent?.let {
            // Get photo ID with default, no extra null check needed
            photo.setImageResource(it.getIntExtra("photo", R.drawable.movie_default_pic))
            // Get title, set if not null
            title.text = it.getStringExtra("title") ?: ""
            // Get year, convert to String
            year.text = it.getIntExtra("year", 0).toString()
            // Get ID, convert to String (assuming ID is Int; if String, adjust accordingly)
            id.text = it.getIntExtra("id", 0).toString()
        }
    }
}