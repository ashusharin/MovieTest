package com.shusharin.movietest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {

    fun GetAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }
}