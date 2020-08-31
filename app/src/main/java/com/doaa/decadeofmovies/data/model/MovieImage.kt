/*
 * Created by Doaa Fouad on 8/31/20 1:28 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 1:28 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.data.model

import com.google.gson.annotations.SerializedName

data class MovieImageResponse(
    @SerializedName("photos")
    var photos: MovieImageDataResponse?
)

data class MovieImageDataResponse(
    @SerializedName("photo")
    var photo: List<MovieImage>?
)

data class MovieImage(
    @SerializedName("id")
    var id: String?,

    @SerializedName("server")
    var server: String?,

    @SerializedName("secret")
    var secret: String?,

    @SerializedName("farm")
    var farm: String?
)