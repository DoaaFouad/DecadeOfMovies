/*
 * Created by Doaa Fouad on 8/30/20 4:13 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 4:13 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.data.model.MoviesResponse
import com.doaa.decadeofmovies.data.repository.FileRepository
import com.doaa.decadeofmovies.ui.base.BaseViewModel
import com.doaa.decadeofmovies.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesMasterViewModel(val fileRepository: FileRepository) : BaseViewModel() {

    private val _movies = MutableLiveData<Resource<MoviesResponse>>()
    val movies: LiveData<Resource<MoviesResponse>> = _movies

    private val _filterResult = MutableLiveData<List<Movie>>()
    val filterResult: LiveData<List<Movie>> = _filterResult

    fun readMoviesFromLocalFile() {
        val moviesObservable = fileRepository.readObjectFromJsonFile("movies.json")
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { _movies.postValue(Resource.loading(null)) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                _movies.postValue(Resource.success(response))
            }, { err ->
                _movies.postValue(Resource.error(err.localizedMessage, null))
            })
        compositeDisposable.add(moviesObservable)
    }

    fun filter(year: Int) {
        movies.value?.data?.movies?.let { movies ->
            _filterResult.postValue(searchAndSortByYear(year, movies))
        }
    }

    fun searchAndSortByYear(year: Int, movies: List<Movie>): List<Movie> {
        return movies.filter { movie -> movie.year == year }
            .sortedByDescending { movie -> movie.rating }
            .take(5)
    }
}