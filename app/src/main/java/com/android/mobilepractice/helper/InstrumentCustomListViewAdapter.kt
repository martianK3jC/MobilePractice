package com.android.mobilepractice.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.mobilepractice.R
import com.android.mobilepractice.data.Instrument

class InstrumentCustomListViewAdapter(
    private val context: Context,
    private val instrumentList: List<Instrument>,
    private val onClick: (Instrument) -> Unit,
    private val onLongClick: (Instrument) -> Unit
    ) : BaseAdapter() {
    override fun getCount(): Int = instrumentList.size

    override fun getItem(position: Int): Any = instrumentList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Inflate
        val view = convertView ?: LayoutInflater
            .from(context)
            .inflate(R.layout.instrument_item_custom_list_view,parent,false)

        //Find UI elements using view.findViewById
        val instrumentPic = view.findViewById<ImageView>(R.id.image_view_instrument_pic)
        val instrumentName = view.findViewById<TextView>(R.id.text_view_instrument_name)
        val instrumentColor = view.findViewById<TextView>(R.id.text_view_instrument_color)

        //Get current flower data
        val instrument = instrumentList[position]
        //Set data to current ui elements
        instrumentPic.setImageResource(instrument.photo)
        instrumentName.setText("${instrument.name}")
        instrumentColor.setText("${instrument.color}")

        //set up click listeners. using view.setOnClickListners
        view.setOnClickListener {
            onClick(instrument)
        }

        view.setOnLongClickListener {
            onLongClick(instrument)
            true
        }

        //return view
        return view
    }


}