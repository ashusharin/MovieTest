package com.shusharin.movietest.data.api

import com.skydoves.sandwich.ApiResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


//Service
interface MovieApi {

    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getMovieList(
        @Query("api-key") key: String = "7QCIZ4hf7Gu8OalDqfpk6qAbcZNtYKPr",
        @Query("offset") page: Int,
    ): Response<MovieListResponse>



}