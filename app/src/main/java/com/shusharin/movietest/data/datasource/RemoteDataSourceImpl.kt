package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.api.ApiClient
import com.shusharin.movietest.data.api.MovieListResponse
import com.shusharin.movietest.domain.Movie
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient):RemoteDataSource {

    override fun getAllMovies(): Single<MovieListResponse> {
       return apiClient.getMovies()
    }
}