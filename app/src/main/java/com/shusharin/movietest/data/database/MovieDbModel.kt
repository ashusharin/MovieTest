package com.shusharin.movietest.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity
data class MovieDbModel @Inject constructor(
    @PrimaryKey
    val name: String,
    val description: String,
    val poster: String,
)
