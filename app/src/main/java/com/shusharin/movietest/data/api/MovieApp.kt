package com.shusharin.movietest.data.api

import android.app.Application


class MovieApp : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.create()
    }


}