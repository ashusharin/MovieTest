package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.api.MovieListResponse
import com.shusharin.movietest.domain.Movie
import io.reactivex.Single

interface RemoteDataSource {

    fun getAllMovies(): Single<MovieListResponse>
}