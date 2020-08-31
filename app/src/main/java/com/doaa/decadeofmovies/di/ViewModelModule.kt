/*
 * Created by Doaa Fouad on 8/30/20 3:49 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 3:49 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.di

import com.doaa.decadeofmovies.ui.main.moviedetails.MovieDetailsViewModel
import com.doaa.decadeofmovies.ui.main.moviesmaster.MoviesMasterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesMasterViewModel(get()) }
    viewModel { MovieDetailsViewModel(get()) }
}