package com.shusharin.movietest.data.datasource


import com.shusharin.movietest.data.database.Database
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val database: Database) : LocalDataSource {

    override fun getMoviesFromDB() {
        database.getMoviesFromDB()
    }
}