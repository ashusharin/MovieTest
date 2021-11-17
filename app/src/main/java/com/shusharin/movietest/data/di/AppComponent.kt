package com.shusharin.movietest.data.di

import com.shusharin.movietest.presentation.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
}