package com.android.mobilepractice

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.mobilepractice.data.Instrument
import com.android.mobilepractice.helper.FlowerCustomListViewAdapter
import com.android.mobilepractice.helper.InstrumentCustomListViewAdapter
import com.android.mobilepractice.utils.toast

class InstrumentCustomListViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument_custom_list_view)

        //Find listView
        val listView = findViewById<ListView>(R.id.custom_listview_instrument)
        //Create data source
        val instrumentList = listOf(
            Instrument("Violin", "Brown", R.drawable.ic_launcher_background),
            Instrument("Guitar", "Brown", R.drawable.ic_launcher_background),
            Instrument("Viola", "Brown", R.drawable.ic_launcher_background),
            Instrument("Cello", "Brown", R.drawable.ic_launcher_background),
            Instrument("Bass", "Brown", R.drawable.ic_launcher_background),
        )

        //implement adapter
        val adapter = InstrumentCustomListViewAdapter(
            this,
            instrumentList,
            //implement the click listeners
            onClick = {instrument ->
                toast("${instrument.name} is clicked")
            },
            onLongClick = { instrument ->
                toast("${instrument.name} has a ${instrument.color} color")
            }
        )

        //listView.adapter = adapter
        listView.adapter = adapter
    }
}