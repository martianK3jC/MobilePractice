package com.android.mobilepractice

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.mobilepractice.utils.toast

class FoodSimpleListViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_simple_list_view)

        //Data source
        val foodList = listOf("Burger", "Pizza", "French fries", "Ice Cream", "Macaroni Soup", "Fried Chicken")
        //arrayAdapter
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList)
        //listView.adapter
        val listView = findViewById<ListView>(R.id.food_listView)
        listView.adapter = arrayAdapter

        listView.setOnItemLongClickListener { _, _, position, _ ->
            toast("${foodList[position]} is clicked!")
            true
        }
    }
}