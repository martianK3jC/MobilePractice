package com.android.mobilepractice

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SimpleListViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        //create list
        val userList = listOf("Katsuki", "Karma", "Kei", "Kesha", "Charmi", "Happy")

        //instantiate listView
//        val listView = findViewById<ListView>(R.id.list_view)
        //Create array adapter
        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            userList
            )
    }
}