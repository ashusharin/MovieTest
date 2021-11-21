package com.shusharin.movietest.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shusharin.movietest.data.datasource.LocalDataSource
import com.shusharin.movietest.data.datasource.RemoteDataSource
import com.shusharin.movietest.data.mapper.MovieMapper
import com.shusharin.movietest.domain.Movie
import com.shusharin.movietest.domain.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.function.ToDoubleBiFunction
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: MovieMapper,
) : MovieRepository {

    var listMovieLD = MutableLiveData<List<Movie>>()
    private var _movieList = mutableListOf<Movie>()
    var page: Int = 0
    private val offset = 20
    private var hasMore: Boolean? = null

    override fun getAllMovies(): LiveData<List<Movie>> {
        var movieList = mapper.mapListDbModeltoListEntity(localDataSource.getMoviesFromDB())


        if (movieList.isEmpty()) {
            val response = remoteDataSource.getAllMovies()

            response
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("данные", "первый пошел")
                    hasMore = it.has_more
                    if (hasMore == true) page += offset
                    for (item in it.results) {
                        val name = item.display_title
                        val description = item.summary_short
                        val poster = item.multimedia.src
                        val movie = Movie(name, description, poster)
                        _movieList.add(movie)
                    }
                    updateList()
                    Log.d("Network", "Getting list: ${listMovieLD.value}")
                },
                    {
                        Log.d("Network", "Request error: $it")
                    })
        }

        return listMovieLD
    }


    private fun updateList() {
        listMovieLD.value = _movieList.toList().distinct()
    }
}