package com.shusharin.movietest.data.api

import retrofit2.Response
import javax.inject.Inject


class ApiClient @Inject constructor(
    private val movieApi: MovieApi
) {


val offset = 20


   suspend fun getMovies(page:Int): Response<MovieListResponse> {
        return movieApi.getMovieList(page = page*offset)
    }
}

