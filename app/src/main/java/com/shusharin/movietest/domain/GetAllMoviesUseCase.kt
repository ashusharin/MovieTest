package com.shusharin.movietest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {



    operator fun invoke():LiveData<List<Movie>>{
        return movieRepository.getAllMovies()
    }

}