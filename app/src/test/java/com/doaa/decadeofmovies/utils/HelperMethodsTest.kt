/*
 * Created by Doaa Fouad on 8/30/20 5:15 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 5:15 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.doaa.decadeofmovies.data.model.MovieImage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HelperMethodsTest {

    @Test
    fun getJsonFileFromAssets_read_returnNotNull() {
        //given
        val fileName = "movies.json"
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        //when
        var fileString = appContext.loadJSONFromAssets(fileName)
        //then
        assertThat(fileString, `is`(notNullValue()))
    }

    @Test
    fun getFlickrImageResponse_convertFullUrl_returnValidUrl() {
        //given
        val movieImage = MovieImage(id = "1", server = "1", secret = "1", farm = "1")
        val expectedUrl = "https://farm1.static.flickr.com/1/1_1.jpg"
        //when
        var url = movieImage.getFullUrl()
        //then
        assertThat(url, equalTo(expectedUrl))
    }

}