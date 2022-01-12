package com.itfun.l2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val movies = listOf<Movie>(
        Movie(R.drawable.pirates1, "Pirates of the Caribbean One", 9.7),
        Movie(R.drawable.pirates2, "Pirates of the Caribbean Two", 9.4),
        Movie(R.drawable.pirates3, "Pirates of the Caribbean Three", 9.7),
        Movie(R.drawable.pirates4, "Pirates of the Caribbean Four", 9.4)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = movies[position].titleMovie
        holder.itemRating.text = movies[position].ratingMovie.toString()
        holder.itemImage.setImageResource(movies[position].imageMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle : TextView
        var itemRating : TextView

        init {
            itemImage = itemView.findViewById(R.id.image_movie)
            itemTitle = itemView.findViewById(R.id.title_movie)
            itemRating = itemView.findViewById(R.id.rating_movie)
        }
    }
}