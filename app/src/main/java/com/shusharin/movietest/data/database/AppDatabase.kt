package com.shusharin.movietest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MovieDbModel::class,], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO


}