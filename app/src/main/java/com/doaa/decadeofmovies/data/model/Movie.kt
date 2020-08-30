/*
 * Created by Doaa Fouad on 8/30/20 5:22 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 5:22 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.data.model

data class MoviesResponse(
    var movies : List<Movie>?
)

data class Movie(
    var title : String?,
    var year : String?
)