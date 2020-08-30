/*
 * Created by Doaa Fouad on 8/30/20 4:12 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 4:12 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.ui.base.BaseActivity
import com.doaa.decadeofmovies.utils.Status
import kotlinx.android.synthetic.main.activity_movies_master.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesMasterActivity : BaseActivity() {

    override val viewModel by viewModel<MoviesMasterViewModel>()
    override val layoutRes = R.layout.activity_movies_master

    private var moviesAdapter: MoviesAdapter? = null

    private fun initRecyclerViewer() {
        val layoutManager = LinearLayoutManager(this)
        rv_movies?.layoutManager = layoutManager

        moviesAdapter = MoviesAdapter()
        rv_movies?.adapter = moviesAdapter
    }

    private fun setMoviesList(moviesList: List<Movie>?) {
        moviesList?.let {
            moviesAdapter?.setData(moviesList)
        }
    }

    override fun initViews() {
        initRecyclerViewer()

        viewModel.readMoviesFromLocalFile()
    }

    override fun observeViewModel() {
        viewModel.movies.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    setMoviesList(it.data?.movies)
                    hideProgress()
                }
                Status.LOADING -> {
                    showProgress()
                }
                Status.ERROR -> {
                    hideProgress()
                }
            }
        })
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.GONE
    }

}