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

// extension to load json file from assets
fun Context.loadJSONFromAssets(fileName: String): String? {
    return applicationContext.assets.open(fileName).bufferedReader().use { reader ->
        reader.readText()
    }
}