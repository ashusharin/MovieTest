package com.shusharin.movietest.data.datasource


import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.database.Database
import com.shusharin.movietest.data.database.MovieDbModel
import com.shusharin.movietest.domain.Movie
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val database: Database) : LocalDataSource {

    override fun getMoviesFromDB(): List<MovieDbModel> {
     return  database.getMoviesFromDB()
    }

    override fun insertMoviesInDB(movieList:List<Movie>) {
        database.insertMoviesInDB(movieList)
    }
}