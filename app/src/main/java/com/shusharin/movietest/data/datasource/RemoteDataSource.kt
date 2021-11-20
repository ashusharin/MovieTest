package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.domain.Movie

interface RemoteDataSource {

    fun getAllMovies(): LiveData<List<Movie>>
}