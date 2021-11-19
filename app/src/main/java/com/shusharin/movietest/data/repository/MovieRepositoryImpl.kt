package com.shusharin.movietest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shusharin.movietest.data.datasource.LocalDataSource
import com.shusharin.movietest.data.datasource.RemoteDataSource
import com.shusharin.movietest.domain.Movie
import com.shusharin.movietest.domain.MovieRepository

class MovieRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {


    override fun getAllMovies(): LiveData<List<Movie>> {
        remoteDataSource.getAllMovies()
        return MutableLiveData<List<Movie>>()
    }
}