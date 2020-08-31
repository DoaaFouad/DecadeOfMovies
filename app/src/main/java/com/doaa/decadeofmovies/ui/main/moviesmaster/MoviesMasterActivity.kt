/*
 * Created by Doaa Fouad on 8/30/20 4:12 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 4:12 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.ui.base.BaseActivity
import com.doaa.decadeofmovies.ui.main.moviedetails.MovieDetailsActivity
import com.doaa.decadeofmovies.utils.Status
import com.google.gson.Gson
import com.whiteelephant.monthpicker.MonthPickerDialog
import kotlinx.android.synthetic.main.activity_movies_master.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MoviesMasterActivity : BaseActivity(), MoviesAdapterListener,
    MonthPickerDialog.OnDateSetListener {

    override val viewModel by viewModel<MoviesMasterViewModel>()
    override val layoutRes = R.layout.activity_movies_master

    private var moviesAdapter: MoviesAdapter? = null
    private var datePickerDialog: MonthPickerDialog.Builder? = null

    private fun initRecyclerViewer() {
        val layoutManager = LinearLayoutManager(this)
        rv_movies?.layoutManager = layoutManager

        moviesAdapter = MoviesAdapter(this)
        rv_movies?.adapter = moviesAdapter
    }

    private fun setMoviesList(moviesList: List<Movie>?) {
        moviesList?.let {
            moviesAdapter?.setData(moviesList)
        }
    }

    // when user select a movie from the list, navigate to movie details view
    override fun onMovieSelected(movie: Movie) {
        navigateToMovieDetails(movie)
    }

    private fun navigateToMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putString("movie", Gson().toJson(movie))
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun initDatePicker() {
        val today = Calendar.getInstance()
        datePickerDialog =
            MonthPickerDialog.Builder(
                this,
                this,
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH)
            )

        datePickerDialog?.setMinYear(1990)?.setActivatedYear(2020)
            ?.setMaxYear(2020)
            ?.showYearOnly()
            ?.setOnYearChangedListener {
            }
    }

    private fun openDatePicker() {
        datePickerDialog?.build()?.show()
    }

    override fun onDateSet(selectedMonth: Int, selectedYear: Int) {
    }

    private fun filterMoviesByYear(selectedYear: Int?){

    }

    override fun initViews() {
        initRecyclerViewer()
        initDatePicker()

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

    override fun setClickListeners() {
        iv_filter?.setOnClickListener {
            openDatePicker()
        }
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.GONE
    }
}