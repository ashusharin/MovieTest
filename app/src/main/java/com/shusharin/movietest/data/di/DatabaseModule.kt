package com.shusharin.movietest.data.di

import android.app.Application
import androidx.room.Room
import com.shusharin.movietest.data.database.AppDatabase
import com.shusharin.movietest.data.database.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(private val application: Application) {



    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "Movie.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDAO {
        return appDatabase.movieDao()
    }

    @Provides
    fun provideApplication():Application{
        return application
    }


}