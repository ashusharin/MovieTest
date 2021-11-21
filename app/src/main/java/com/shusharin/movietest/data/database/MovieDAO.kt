package com.shusharin.movietest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shusharin.movietest.domain.Movie


@Dao
interface MovieDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonList(movieList: List<MovieDbModel>)


    @Query("SELECT * FROM MovieDbModel")
    fun getMovieList(): List<MovieDbModel>
}