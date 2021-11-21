package com.shusharin.movietest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shusharin.movietest.domain.Movie


@Dao
interface MovieDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<Movie>)


    @Query("SELECT * FROM MovieDdModel")
    suspend fun getMovieList(page_: Int): List<Movie>
}