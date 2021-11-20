package com.shusharin.movietest.data.di

import com.shusharin.movietest.data.api.ApiClient
import com.shusharin.movietest.data.api.MovieApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
class RetrofitModule {
    val BASE_URL = "https://api.nytimes.com"
    val API_KEY = "7QCIZ4hf7Gu8OalDqfpk6qAbcZNtYKPr"


        @Singleton
        @Provides
        fun provideRetrofitService(@NYRetrofitClient retrofit: Retrofit): MovieApi {
            return retrofit.create(MovieApi::class.java)
        }


    @Singleton
    @Provides
    fun provideApiClient(movieApi: MovieApi): ApiClient {
        return ApiClient(movieApi)
    }


    @Singleton
    @Provides
    @NYRetrofitClient
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .build()
                return@addInterceptor chain.proceed(request)
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }


}