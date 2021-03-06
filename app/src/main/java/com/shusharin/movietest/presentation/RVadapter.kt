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
import com.shusharin.movietest.databinding.MovieCardBinding
import com.shusharin.movietest.domain.Movie
import com.squareup.picasso.Picasso

class RVadapter : RecyclerView.Adapter<RVadapter.MovieItemViewHolder>() {


    var movieList = listOf<Movie>()
        set(value) {
            val callback = MovieListDiffCallback(movieList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    class MovieItemViewHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)

        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movie = movieList[position]
        val binding = holder.binding
        Picasso.get().load(movie.poster).into(binding.imageViewPoster)
        binding.movieName.text = movie.name
        Log.d("Recyclerview", "holder: $position ")
        binding.tvDescription.text = movie.description

    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    override fun onViewRecycled(viewHolder: MovieItemViewHolder) {
        super.onViewRecycled(viewHolder)
        val binding = viewHolder.binding
            binding.imageViewPoster.setImageResource(0);

    }


}