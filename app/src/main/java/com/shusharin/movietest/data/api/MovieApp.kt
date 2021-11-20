package com.shusharin.movietest.data.api

import android.app.Application
import android.content.Context
import com.shusharin.movietest.data.di.AppComponent
import com.shusharin.movietest.data.di.DaggerAppComponent
import dagger.internal.DaggerGenerated
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory




class MovieApp : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.create()
    }


}