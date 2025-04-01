package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mobilepractice.data.Movie
import com.android.mobilepractice.helper.MovieRecyclerViewAdapter

class MovieRecyclerViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_recycler_view)

        //declare data source
        val movieList = listOf(
            Movie(1, "Brother Bear", 2003, R.drawable.brother_bear_2),
            Movie(2, "Cinderella 3", 2007, R.drawable.cinderella_3),
            Movie(3, "Emperor's New Groove", 2000, R.drawable.emperors_new_groove),
            Movie(4, "Princess and the Frog", 2009, R.drawable.princess_and_the_frog_2),
            Movie(5, "Tarzan", 1999, R.drawable.tarzan_1)
        )

        //Find RecyclerView layout
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_movie)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //set adapter with click handler to go to another page
        recyclerView.adapter = MovieRecyclerViewAdapter(movieList){movie ->
            startActivity(Intent(this, MovieDetailsActivity::class.java).apply {
                //pass movie data to details activity
                putExtra("photo", movie.photo)
                putExtra("title", movie.title)
                putExtra("id", movie.movieId)
                putExtra("year", movie.year)
            })

        }
    }
}