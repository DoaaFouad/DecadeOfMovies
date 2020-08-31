/*
 * Created by Doaa Fouad on 8/30/20 3:47 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 3:47 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.data.api

import com.doaa.decadeofmovies.data.model.MovieImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPIService {

    @GET("services/rest/")
    fun searchPhoto(
        @Query("method") method: String?,
        @Query("api_key") apiKey: String?,
        @Query("format") format: String?,
        @Query("nojsoncallback") noJson: Int?,
        @Query("text") searchText: String?,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): Single<MovieImageResponse>
}