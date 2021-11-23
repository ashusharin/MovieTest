package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.database.MovieDbModel
import com.shusharin.movietest.domain.Movie

interface LocalDataSource {
    suspend fun getMoviesFromDB(page:Int): List<Movie>

    suspend fun insertMoviesInDB(movieList:List<Movie>)
}