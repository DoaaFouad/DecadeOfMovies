/*
 * Created by Doaa Fouad on 8/30/20 5:12 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 5:12 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.utils

import android.content.Context
import com.doaa.decadeofmovies.data.model.MovieImage

// extension to load json file from assets
fun Context.loadJSONFromAssets(fileName: String): String? {
    return applicationContext.assets.open(fileName).bufferedReader().use { reader ->
        reader.readText()
    }
}

// extension to convert flickr response to meaningful url
fun MovieImage.getFullUrl(): String? {
    return "https://farm${farm}.static.flickr.com/${server}/${id}_${secret}.jpg"
}