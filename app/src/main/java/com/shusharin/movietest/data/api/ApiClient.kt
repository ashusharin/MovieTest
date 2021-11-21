package com.shusharin.movietest.data.api

import io.reactivex.Single
import javax.inject.Inject


class ApiClient @Inject constructor(
    private val movieApi: MovieApi,
) {


    var page: Int = 0


    fun getMovies(): Single<MovieListResponse> {
        return movieApi.getMovieList(page = page)
    }
}