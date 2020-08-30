/*
 * Created by Doaa Fouad on 8/30/20 3:51 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 3:51 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies

import android.app.Application
import com.doaa.decadeofmovies.di.adapterModule
import com.doaa.decadeofmovies.di.apiModule
import com.doaa.decadeofmovies.di.repositoryModule
import com.doaa.decadeofmovies.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class DecadeOfMoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@DecadeOfMoviesApplication)
            modules(listOf(viewModelModule, repositoryModule, apiModule, adapterModule))
        }
    }
}