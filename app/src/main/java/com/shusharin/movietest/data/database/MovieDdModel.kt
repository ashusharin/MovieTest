package com.shusharin.movietest.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieDdModel(
    @PrimaryKey
    val name: String,
    val description: String,
    val poster: String,
)
