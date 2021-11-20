package com.shusharin.movietest.data.database

import android.util.Log
import javax.inject.Inject

class Database @Inject constructor() {

    fun getMoviesFromDB() {
        Log.d("тестирование", "Database().getMoviesFromDB()")
    }
}