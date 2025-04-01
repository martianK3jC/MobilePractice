package com.android.mobilepractice.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mobilepractice.R
import com.android.mobilepractice.data.Movie

class MovieRecyclerViewAdapter(
    private val movieList: List<Movie>,
    private val onClick : (Movie) -> Unit
    ) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val photo = view.findViewById<ImageView>(R.id.image_view_movie_pic)
        val title = view.findViewById<TextView>(R.id.text_view_movie_name)
        val year = view.findViewById<TextView>(R.id.text_view_movie_year)
        val id = view.findViewById<TextView>(R.id.text_view_movie_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_recycler_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = movieList[position]
        holder.photo.setImageResource(item.photo)
        holder.title.text = item.title
        holder.year.text = item.year.toString()
        holder.id.text = item.movieId.toString()
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
}