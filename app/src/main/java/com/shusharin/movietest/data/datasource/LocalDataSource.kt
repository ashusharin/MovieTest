package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.database.MovieDbModel

interface LocalDataSource {
    fun getMoviesFromDB(): List<MovieDbModel>
}