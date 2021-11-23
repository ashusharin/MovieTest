package com.shusharin.movietest.data.datasource


import com.shusharin.movietest.data.database.Database
import com.shusharin.movietest.data.mapper.MovieMapper
import com.shusharin.movietest.domain.Movie
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val database: Database,
private val mapper:MovieMapper) : LocalDataSource {

    override suspend fun getMoviesFromDB(page:Int): List<Movie> {
     return  mapper.mapListDbModeltoListEntity(database.getMoviesFromDB(page))
    }

    override suspend fun insertMoviesInDB(movieList:List<Movie>) {
        database.insertMoviesInDB(mapper.mapListEntityToListDbModel(movieList))
    }
}