package com.shusharin.movietest.data.di

import android.app.Application

import com.shusharin.movietest.data.datasource.LocalDataSource
import com.shusharin.movietest.data.datasource.LocalDataSourceImpl
import com.shusharin.movietest.data.datasource.RemoteDataSource
import com.shusharin.movietest.data.datasource.RemoteDataSourceImpl
import com.shusharin.movietest.data.repository.MovieRepositoryImpl
import com.shusharin.movietest.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

// Interface потому что все методы без реализации
//@Module
//interface DataModul {
//
//
//    //Для реализации в dagger интерфейса используется Bind
//    @Binds
//    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource
//
//
//    @Binds
//    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
//}


//Application передаем в качестве параметра для ретрофит. Вызов DaggerAppComponent через Build()
@Module
class DataModul(private val application: Application) {



    //Для реализации в dagger интерфейса используется Bind
    @Provides
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource{
        return impl
    }

    @Provides
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource{
        return impl
    }
}