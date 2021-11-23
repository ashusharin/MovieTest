package com.shusharin.movietest.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shusharin.movietest.data.datasource.LocalDataSource
import com.shusharin.movietest.data.datasource.RemoteDataSource
import com.shusharin.movietest.data.mapper.MovieMapper
import com.shusharin.movietest.domain.Movie
import com.shusharin.movietest.domain.MovieRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {

    override fun getAllMovies(
        page: Int,
    ): Flow<List<Movie>> = flow {
        val movieList = localDataSource.getMoviesFromDB(page).toMutableList()

        if (movieList.isEmpty()) {
            movieList.toMutableList()
            val response = remoteDataSource.getAllMovies(page)
            response.suspendOnSuccess {
                data.results.forEach {
                    val name = it.display_title
                    val description = it.summary_short
                    val poster = it.multimedia.src
                    val movie = Movie(name, description, poster, page)
                    movieList.add(movie)
                    localDataSource.insertMoviesInDB(movieList)

                }
                emit(localDataSource.getMoviesFromDB(page))
            }
                .onError {
                    Log.d("Suspend function", "Error")
                }
                .onException {
                    Log.d("Suspend function", "Exception")
                }


        } else {
            emit(localDataSource.getMoviesFromDB(page))

        }

    }.flowOn(Dispatchers.IO)
}