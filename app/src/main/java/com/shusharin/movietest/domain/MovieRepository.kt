package com.shusharin.movietest.domain

import androidx.lifecycle.LiveData
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllMovies(page: Int):Flow<List<Movie>>

}