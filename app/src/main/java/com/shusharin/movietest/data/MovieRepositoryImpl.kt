package com.shusharin.movietest.data

import androidx.lifecycle.LiveData
import com.shusharin.movietest.domain.Movie
import com.shusharin.movietest.domain.MovieRepository

class MovieRepositoryImpl: MovieRepository {



    override fun getAllMovies(): LiveData<List<Movie>> {
        TODO("Not yet implemented")
    }
}