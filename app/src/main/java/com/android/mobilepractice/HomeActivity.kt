package com.android.mobilepractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.mobilepractice.app.MyApplication

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button_login = findViewById<Button>(R.id.button_login)
        val tv_fullname = findViewById<TextView>(R.id.tv_fullname)
        val button_simple_list_view = findViewById<Button>(R.id.button_simple_list_view)
        val button_custom_list_view = findViewById<Button>(R.id.button_custom_list_view)
        val button_food_list = findViewById<Button>(R.id.button_food_list)
        val button_instrument = findViewById<Button>(R.id.button_instrument_custom_list_view)
        val button_movie = findViewById<Button>(R.id.button_movie_recycler_view)
        // Get fullname from application storage
        tv_fullname.text = (application as MyApplication).fullname

        // Handle login button click
        button_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        button_simple_list_view.setOnClickListener {
            val intent = Intent(this, SimpleListViewActivity::class.java)
            startActivity(intent)
        }

        button_food_list.setOnClickListener {
            startActivity(
                Intent(this, FoodSimpleListViewActivity::class.java)
            )
        }

        button_custom_list_view.setOnClickListener {
            val intent = Intent(this, CustomListViewActivity::class.java)
            startActivity(intent)
        }

        button_instrument.setOnClickListener {
            val intent = Intent(this, InstrumentCustomListViewActivity::class.java)
            startActivity(intent)
        }

        button_movie.setOnClickListener {
            val intent = Intent(this, MovieRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        // Lesson: Passing data via Intent
        /*
        intent?.let {
            it.getStringExtra("fullname")?.let { fullname ->
                tv_fullname.text = fullname
            }
        }
        */
    }
}
