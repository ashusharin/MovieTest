package com.shusharin.movietest.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.movietest.R
import com.shusharin.movietest.domain.Movie
import com.squareup.picasso.Picasso

class RVadapter : RecyclerView.Adapter<RVadapter.MovieItemViewHolder>() {

    var OnReachEndListener: (() -> Unit)? = null

    var movieList = listOf<Movie>()
        set(value) {
            val callback = MovieListDiffCallback(movieList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    class MovieItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var poster = view.findViewById<ImageView>(R.id.imageViewPoster)
        var name = view.findViewById<TextView>(R.id.movieName)
        var description = view.findViewById<TextView>(R.id.tv_description)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MovieItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movie = movieList[position]
        Picasso.get().load(movie.poster).into(holder.poster)
        holder.name.text = movie.name
        Log.d("ресв", "карточка: $position ")
        holder.description.text = movie.description
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    override fun onViewRecycled(viewHolder: MovieItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.poster.setImageResource(0);

    }


}