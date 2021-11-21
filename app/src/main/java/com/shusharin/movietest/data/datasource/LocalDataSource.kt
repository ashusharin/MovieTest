package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.database.MovieDbModel
import com.shusharin.movietest.domain.Movie

interface LocalDataSource {
    fun getMoviesFromDB(): List<MovieDbModel>

    fun insertMoviesInDB(movieList:List<Movie>)
}