package com.shusharin.movietest.data.datasource


import androidx.lifecycle.LiveData
import com.shusharin.movietest.data.database.Database
import com.shusharin.movietest.data.database.MovieDbModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val database: Database) : LocalDataSource {

    override fun getMoviesFromDB(): List<MovieDbModel> {
     return  database.getMoviesFromDB()
    }
}