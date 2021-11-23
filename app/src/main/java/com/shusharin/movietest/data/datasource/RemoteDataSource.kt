package com.shusharin.movietest.data.datasource

import com.shusharin.movietest.data.api.MovieListResponse
import com.skydoves.sandwich.ApiResponse

interface RemoteDataSource {

    suspend fun getAllMovies(page:Int): ApiResponse<MovieListResponse>
}