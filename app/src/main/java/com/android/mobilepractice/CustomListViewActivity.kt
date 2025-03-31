package com.android.mobilepractice

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.android.mobilepractice.data.Flower
import com.android.mobilepractice.helper.FlowerCustomListViewAdapter
import com.android.mobilepractice.utils.toast

class CustomListViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        val listView = findViewById<ListView>(R.id.list_view_flower_list)
        if (listView == null) {
            toast("Error: ListView not found")
            return
        }

        val flowerList = listOf(
            Flower("Rose", "Rosa", R.drawable.rose),
            Flower("Sunflower", "Helianthus annuus", R.drawable.sunflower),
            Flower("Tulip", "Tulipa", R.drawable.tulip),
            Flower("Orchid", "Orchidaceae", R.drawable.orchid),
            Flower("Lily", "Lilium", R.drawable.lily)
        )

        val adapter = FlowerCustomListViewAdapter(
            this,
            flowerList,
            onClick = {flower ->
                toast("${flower.flowerName} is cliked!")
            }, onLongClick = {flower ->
                toast("${flower.flowerName} is long cliked!")
            }
        )
        listView.adapter = adapter
    }
}