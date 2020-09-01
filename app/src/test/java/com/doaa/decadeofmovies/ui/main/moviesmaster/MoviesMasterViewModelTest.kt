/*
 * Created by Doaa Fouad on 9/1/20 2:06 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 9/1/20 2:06 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.di.repositoryModule
import com.doaa.decadeofmovies.di.viewModelModule
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Test class responsible for testing MoviesMasterViewModel functions
 * extending koinTest for managing dependencies
 **/
@RunWith(AndroidJUnit4::class)
class MoviesMasterViewModelTest : KoinTest {

    private val moviesMasterViewModel: MoviesMasterViewModel by inject() // lazy initialization

    @Test
    fun searchAndSortList_listContainsDiffYears_returnOnly2017Sorted() {
        //given
        val listOFMovies = arrayListOf<Movie>()
        listOFMovies.add(Movie(title = "dummy1", year = 2017, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy2", year = 2017, rating = 4f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy3", year = 2017, rating = 5f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy4", year = 2017, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy5", year = 2017, rating = 1f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy6", year = 2018, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy7", year = 2017, rating = 5f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy6", year = 2019, rating = 5f, cast = null, genres = null))

        val expectedListOfMovies = arrayListOf<Movie>()
        expectedListOfMovies.add(Movie(title = "dummy3", year = 2017, rating = 5f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy7", year = 2017, rating = 5f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy2", year = 2017, rating = 4f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy1", year = 2017, rating = 3f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy4", year = 2017, rating = 3f, cast = null, genres = null))

        //when
        var outputList = moviesMasterViewModel.searchAndSortByYear(2017, listOFMovies)
        //then
        Assert.assertEquals(expectedListOfMovies, outputList)
    }

    @Test
    fun searchAndSortList_listContainsDiffRatings2017_returnSorted() {
        //given
        val listOFMovies = arrayListOf<Movie>()
        listOFMovies.add(Movie(title = "dummy1", year = 2017, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy2", year = 2017, rating = 4f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy3", year = 2017, rating = 5f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy4", year = 2017, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy5", year = 2017, rating = 1f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy6", year = 2017, rating = 3f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy7", year = 2017, rating = 2f, cast = null, genres = null))
        listOFMovies.add(Movie(title = "dummy8", year = 2017, rating = 5f, cast = null, genres = null))

        val expectedListOfMovies = arrayListOf<Movie>()
        expectedListOfMovies.add(Movie(title = "dummy3", year = 2017, rating = 5f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy8", year = 2017, rating = 5f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy2", year = 2017, rating = 4f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy1", year = 2017, rating = 3f, cast = null, genres = null))
        expectedListOfMovies.add(Movie(title = "dummy4", year = 2017, rating = 3f, cast = null, genres = null))

        //when
        var outputList = moviesMasterViewModel.searchAndSortByYear(2017, listOFMovies)
        //then
        Assert.assertEquals(expectedListOfMovies, outputList)
    }

    @Before
    fun setup() {
        stopKoin() // workaround for issued bug
        startKoin {
            modules(
                listOf(
                    viewModelModule, repositoryModule
                )
            )
            androidContext(
                ApplicationProvider.getApplicationContext()
            )
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}