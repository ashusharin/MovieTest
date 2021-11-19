package com.shusharin.movietest.data.di

import javax.inject.Qualifier

annotation class ClientAnnotation()


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NYRetrofitClient
