package com.shusharin.movietest.domain

data class Movie(
    val name:String,
    val description:String,
    val poster:String,
    var page: Int = 0
)
