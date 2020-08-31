/*
 * Created by Doaa Fouad on 8/31/20 2:24 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 2:24 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import com.doaa.decadeofmovies.data.model.Movie

interface MoviesAdapterListener{
    fun onMovieSelected(movie: Movie)
}