/*
 * Created by Doaa Fouad on 8/30/20 3:46 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 3:46 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.di

import com.doaa.decadeofmovies.data.api.APIService
import com.doaa.decadeofmovies.utils.constants.Network
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    val HTTP_LOGGING_INTERCEPTOR = "HTTP_LOGGING_INTERCEPTOR"
    val RETROFIT_MAIN_CLIENT = "RETROFIT_MAIN_CLIENT"

    single { Gson() }

    single(named(HTTP_LOGGING_INTERCEPTOR)) {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        logInterceptor as Interceptor
    }

    single(named(RETROFIT_MAIN_CLIENT)) {
        OkHttpClient.Builder().addInterceptor(get(named(HTTP_LOGGING_INTERCEPTOR)))
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get(named(RETROFIT_MAIN_CLIENT)))
            .baseUrl(Network.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}