package com.shusharin.movietest.presentation

import androidx.recyclerview.widget.DiffUtil
import com.shusharin.movietest.domain.Movie

class DiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}