/*
 * Created by Doaa Fouad on 8/31/20 12:19 AM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 12:19 AM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.data.model.MovieImageResponse
import com.doaa.decadeofmovies.data.repository.MovieImagesRepository
import com.doaa.decadeofmovies.ui.base.BaseViewModel
import com.doaa.decadeofmovies.utils.Resource
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailsViewModel(val movieImagesRepository: MovieImagesRepository) : BaseViewModel() {

    private val _movieImages = MutableLiveData<Resource<MovieImageResponse>>()
    val movieImages: LiveData<Resource<MovieImageResponse>> = _movieImages

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun getMovieImages(movieName: String) {
        val imagesObservable = movieImagesRepository.getMovieImages(movieName, 1, 5)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { _movieImages.postValue(Resource.loading(null)) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                _movieImages.postValue(Resource.success(response))
            }, { err ->
                _movieImages.postValue(Resource.error(err.localizedMessage, null))
            })
        compositeDisposable.add(imagesObservable)
    }

    // parse movie string passed from master activity to movie object
    fun getPassedMovieObject(movie: String?) {
        _movie.postValue(Gson().fromJson(movie, Movie::class.java))
    }

}