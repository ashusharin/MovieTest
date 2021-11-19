package com.shusharin.movietest.data.datasource

import com.shusharin.movietest.data.api.ApiService

class RemoteDataSourceImpl(private val apiService: ApiService):RemoteDataSource {

    override fun getAllMovies() {
        apiService.getMovies()
    }
}