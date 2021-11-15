package com.shusharin.movietest.domain

import androidx.lifecycle.LiveData

interface MovieRepository {
    fun getAllMovies(): LiveData<List<Movie>>
}