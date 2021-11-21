package com.shusharin.movietest.data.database


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class Database @Inject constructor(private val movieDao: MovieDAO) {
    fun getMoviesFromDB(): List<MovieDbModel> {

        return movieDao.getMovieList()




    }
}