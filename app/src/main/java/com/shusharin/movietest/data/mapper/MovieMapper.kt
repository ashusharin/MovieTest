package com.shusharin.movietest.data.mapper

import com.shusharin.movietest.data.database.MovieDbModel
import com.shusharin.movietest.domain.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() {


    fun mapEntityToDbModel(movie: Movie):MovieDbModel = MovieDbModel(
        name = movie.name,
        description = movie.description,
        poster = movie.poster
    )


    fun mapDbModelToEntity(movieDbModel: MovieDbModel):Movie = Movie(
        name = movieDbModel.name,
        description = movieDbModel.description,
        poster = movieDbModel.poster
    )

    fun mapListDbModeltoListEntity(list:List<MovieDbModel>) =list.map{
        mapDbModelToEntity(it)
    }
}