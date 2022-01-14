package com.itfun.l2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val movies: List<Movie>,
    private val listener: onItemClickListener
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    interface onItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v, listener)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = movies[position].titleMovie
        holder.itemRating.text = movies[position].ratingMovie.toString()
        holder.itemImage.setImageResource(movies[position].imageMovie)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemRating: TextView

        init {
            itemView.setOnClickListener(this)
            itemImage = itemView.findViewById(R.id.image_movie)
            itemTitle = itemView.findViewById(R.id.title_movie)
            itemRating = itemView.findViewById(R.id.rating_movie)
        }

        override fun onClick(p0: View?) {
            listener.onItemClick(adapterPosition)
        }
    }
}