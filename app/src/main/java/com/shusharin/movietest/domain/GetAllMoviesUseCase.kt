package com.shusharin.movietest.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {



    operator fun invoke(page:Int): Flow<List<Movie>> {
        return movieRepository.getAllMovies(page)
    }

}