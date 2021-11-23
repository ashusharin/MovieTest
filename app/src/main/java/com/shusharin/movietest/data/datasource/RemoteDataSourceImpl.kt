package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.api.ApiClient
import com.shusharin.movietest.data.api.MovieListResponse
import com.shusharin.movietest.domain.Movie
import com.skydoves.sandwich.ApiResponse
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient):RemoteDataSource {

    override suspend fun getAllMovies(page:Int): ApiResponse<MovieListResponse> {
       val a = apiClient.getMovies(page)
        return a
    }
}