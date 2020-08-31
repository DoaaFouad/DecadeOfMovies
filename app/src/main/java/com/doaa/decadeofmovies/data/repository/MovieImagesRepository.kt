/*
 * Created by Doaa Fouad on 8/31/20 2:04 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 2:04 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.data.repository

import com.doaa.decadeofmovies.data.api.FlickrAPIService
import com.doaa.decadeofmovies.data.model.MovieImageResponse
import com.doaa.decadeofmovies.utils.constants.Network
import io.reactivex.Single

class MovieImagesRepository(val flickrAPIService: FlickrAPIService) {

    fun getMovieImages(
        movieName: String,
        page: Int,
        perPage: Int
    ): Single<MovieImageResponse> =
        flickrAPIService.searchPhoto(
            method = Network.FLICKR_METHOD_SEARCH,
            apiKey = Network.FLICKR_API_KEY,
            format = "json",
            noJson = 1,
            searchText = movieName,
            page = page,
            perPage = perPage
        )
}