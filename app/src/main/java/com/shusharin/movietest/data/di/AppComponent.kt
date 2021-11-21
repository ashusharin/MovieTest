package com.shusharin.movietest.data.di

import com.shusharin.movietest.presentation.MainActivity
import com.shusharin.movietest.presentation.MainViewModel
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, DataModul::class,DomainModul::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
    fun inject(mainActivity: MainActivity)
}