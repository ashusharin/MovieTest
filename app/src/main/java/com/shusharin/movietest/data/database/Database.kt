package com.shusharin.movietest.data.database


import com.shusharin.movietest.data.mapper.MovieMapper
import com.shusharin.movietest.domain.Movie
import javax.inject.Inject

class Database @Inject constructor(private val movieDao: MovieDAO) {

    suspend fun getMoviesFromDB(page:Int): List<MovieDbModel> {
        return movieDao.getMovieList(page)
    }

    suspend fun insertMoviesInDB(movieList:List<MovieDbModel>){
        movieDao.insertMovieList(movieList)
    }

}