package com.shusharin.movietest.data.di

import com.shusharin.movietest.data.repository.MovieRepositoryImpl
import com.shusharin.movietest.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModul {

    @Binds
    fun bindRepository(impl: MovieRepositoryImpl): MovieRepository
}