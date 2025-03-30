package com.android.mobilepractice

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.mobilepractice.utils.toast

class SimpleListViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        val userList = listOf("Kesha", "Jane", "Ceniza", "Katsuki", "Bakugo", "Karma", "Akabane", "Kei", "Tsukishima")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList)

        val listView = findViewById<ListView>(R.id.list_view_user_list)
        listView.adapter = arrayAdapter

        listView.setOnItemLongClickListener { _, _, position, _ ->
            toast("Long press item ${position + 1} with data ${userList[position]}")
            true // Ensure the event is consumed
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            toast("Item ${position + 1} with data ${userList[position]}")
        }
    }
}
