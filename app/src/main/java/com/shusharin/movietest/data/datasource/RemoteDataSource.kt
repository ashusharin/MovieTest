package com.shusharin.movietest.data.datasource

import androidx.paging.PagingData
import com.shusharin.movietest.domain.Movie
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {

    suspend fun getAllMovies(page:Int): Flow<PagingData<Movie>>
}