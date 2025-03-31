package com.android.mobilepractice.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.mobilepractice.R
import com.android.mobilepractice.data.Flower

class FlowerCustomListViewAdapter(
    private val context: Context,
    private val flowerList: List<Flower>,
    private val onClick: (Flower) -> Unit,
    private val onLongClick: (Flower) -> Unit
) : BaseAdapter(){
    //IMPLEMENT THE MEMBERS

    //size of list
    override fun getCount(): Int = flowerList.size

    //get specific item
    override fun getItem(position: Int): Any = flowerList[position]

    //get item id
    override fun getItemId(position: Int): Long = position.toLong()

    //get item view
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //inflate view with our layout
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.flowers_item_custom_list_view, parent, false)

        //manipulate element inside the view
        val flowerPic = view.findViewById<ImageView>(R.id.image_view_flower_pic)
        val flowerName = view.findViewById<TextView>(R.id.text_view_flowername)
        val scientificFlowerName = view.findViewById<TextView>(R.id.text_view_scientific_flowername)

        //set data/value
        val flower = flowerList[position]
        flowerPic.setImageResource(flower.photoRes)
        flowerName.setText("${flower.flowerName}")
        scientificFlowerName.setText("${flower.scientificFlowerName}")

        view.setOnClickListener {
            onClick(flower)
        }

        view.setOnLongClickListener {
            onLongClick(flower)
            true
        }
        return view;
    }
}