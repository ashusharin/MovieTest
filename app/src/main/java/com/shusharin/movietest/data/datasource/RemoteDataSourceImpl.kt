package com.shusharin.movietest.data.datasource

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.shusharin.movietest.data.api.ApiClient
import com.shusharin.movietest.data.api.MovieListResponse
import com.shusharin.movietest.data.api.PageSource
import com.shusharin.movietest.domain.Movie
import com.skydoves.sandwich.ApiResponse
import io.reactivex.Single
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val pagingSourceFactory: PageSource.Factory,
) : RemoteDataSource {

    override suspend fun getAllMovies(page: Int): Flow<PagingData<Movie>> {
        val a = Pager(PagingConfig(pageSize = 5)) {
            pagingSourceFactory.create()
        }.flow

        return a
    }
}