/*
 * Created by Doaa Fouad on 8/30/20 5:28 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 5:28 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.data.repository

import android.content.Context
import com.doaa.decadeofmovies.data.model.MoviesResponse
import com.doaa.decadeofmovies.utils.loadJSONFromAssets
import com.google.gson.Gson
import io.reactivex.Observable

class FileRepository(val appContext: Context) {

    // load json file from assets, then parse it
    fun readObjectFromJsonFile(fileName: String): Observable<MoviesResponse> {
        return Observable.create<MoviesResponse> { emitter ->
            val fileString = appContext.loadJSONFromAssets(fileName)
            val movies: MoviesResponse = Gson().fromJson(fileString, MoviesResponse::class.java)
            emitter.onNext(movies)
            emitter.onComplete()
        }
    }
}