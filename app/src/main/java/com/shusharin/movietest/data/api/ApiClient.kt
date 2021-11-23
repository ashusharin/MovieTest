package com.shusharin.movietest.data.api

import com.skydoves.sandwich.ApiResponse
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject


class ApiClient @Inject constructor(
    private val movieApi: MovieApi
) {




   suspend fun getMovies(page:Int): ApiResponse<MovieListResponse> {
        return movieApi.getMovieList(page = page)
    }
}