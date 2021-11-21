package com.shusharin.movietest.data.di

import android.app.Application
import com.shusharin.movietest.data.datasource.LocalDataSource
import com.shusharin.movietest.data.datasource.LocalDataSourceImpl
import com.shusharin.movietest.data.datasource.RemoteDataSource
import com.shusharin.movietest.data.datasource.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides


//Application передаем в качестве параметра для ретрофит. Вызов DaggerAppComponent через Build()
@Module
class DataModul(private val application: Application) {



    //Для реализации в dagger интерфейса используется Bind
    @Provides
    fun provideLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource{
        return impl
    }

    @Provides
    fun provideRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource{
        return impl
    }

}