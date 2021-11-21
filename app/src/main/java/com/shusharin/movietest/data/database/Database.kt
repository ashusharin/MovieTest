package com.shusharin.movietest.data.database


import com.shusharin.movietest.data.mapper.MovieMapper
import com.shusharin.movietest.domain.Movie
import javax.inject.Inject

class Database @Inject constructor(private val movieDao: MovieDAO, private val mapper:MovieMapper) {

    fun getMoviesFromDB(): List<MovieDbModel> {
        return movieDao.getMovieList()
    }

    fun insertMoviesInDB(movieList:List<Movie>){
        movieDao.insertMovieList(mapper.mapListEntityToListDbModel(movieList))
    }

}