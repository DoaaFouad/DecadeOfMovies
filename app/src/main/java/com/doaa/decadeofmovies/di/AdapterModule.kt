/*
 * Created by Doaa Fouad on 8/30/20 11:21 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 11:21 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.di

import com.doaa.decadeofmovies.ui.main.moviesmaster.MoviesAdapter
import org.koin.dsl.module

val adapterModule = module {
    single { MoviesAdapter() }
}