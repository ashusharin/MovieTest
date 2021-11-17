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


// Т.к. я не подключил Dagger, то для реализации singleton использую класс MovieApp,
// наследуемый от Application


class MovieApp : Application() {

    lateinit var movieApi: MovieApi
lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
//        configureRetrofit()
    }

    val Context.appComponent: AppComponent
    get() = when (this){
        is MovieApp -> appComponent
        else -> this.applicationContext.appComponent
    }
//    private fun configureRetrofit() {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                    .build()
//                return@addInterceptor chain.proceed(request)
//            }
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.nytimes.com")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//        movieApi = retrofit.create(MovieApi::class.java)
//
//
//    }
}