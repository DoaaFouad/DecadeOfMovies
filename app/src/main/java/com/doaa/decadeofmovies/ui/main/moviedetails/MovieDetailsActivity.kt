/*
 * Created by Doaa Fouad on 8/31/20 12:18 AM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 12:18 AM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviedetails

import android.view.View
import androidx.lifecycle.Observer
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.Movie
import com.doaa.decadeofmovies.data.model.MovieImage
import com.doaa.decadeofmovies.ui.base.BaseActivity
import com.doaa.decadeofmovies.utils.Status
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.progressBar
import kotlinx.android.synthetic.main.activity_movie_details.tv_title
import kotlinx.android.synthetic.main.activity_movies_master.*
import kotlinx.android.synthetic.main.item_movies_master.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class MovieDetailsActivity : BaseActivity() {

    override val viewModel by viewModel<MovieDetailsViewModel>()
    override val layoutRes = R.layout.activity_movie_details

    private var movieImagesAdapter: MovieImagesAdapter? = null

    private fun initCarousel() {
        movieImagesAdapter = MovieImagesAdapter()
        imageSlider_movie.sliderAdapter = movieImagesAdapter
        imageSlider_movie.setIndicatorAnimation(IndicatorAnimations.WORM)
        imageSlider_movie.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider_movie.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider_movie.scrollTimeInSec = 20
        imageSlider_movie.startAutoCycle()
    }

    private fun setImages(movieImages: List<MovieImage>?) {
        movieImagesAdapter?.setData(movieImages)
    }

    private fun setGenre(genres: List<String>?) {
        val genreStringBuilder = StringBuilder()
        genres?.let {
            for (_genre in genres) {
                genreStringBuilder.append(_genre)
                genreStringBuilder.append(", ")
            }
            tv_genre_value?.text = genreStringBuilder
        }
    }

    private fun setCast(cast: List<String>?) {
        val castStringBuilder = StringBuilder()
        cast?.let {
            for (_cast in cast) {
                castStringBuilder.append(_cast)
                castStringBuilder.append(", ")
            }
            tv_cast_value?.text = castStringBuilder
        }
    }

    private fun initViewsMovieDetails(movie: Movie) {
        tv_title?.text = movie.title
        tv_year?.text = movie.year
        movie.rating?.let {
            ratingbar?.rating = it
        }
        movie.title?.let { viewModel.getMovieImages(movieName = it) }
        setGenre(movie.genres)
        setCast(movie.cast)
    }

    private fun movieNullState() {
        showToastMessage(resources.getString(R.string.error))
    }

    override fun initViews() {
        initCarousel()
        viewModel.getPassedMovieObject(intent?.extras?.getString("movie"))
    }

    override fun observeViewModel() {
        viewModel.movie.observe(this, Observer {
            it?.let { movie ->
                initViewsMovieDetails(movie)
            } ?: kotlin.run {
                movieNullState()
            }
        })

        viewModel.movieImages.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    setImages(it.data?.photos?.photo)
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

    override fun onDestroy() {
        super.onDestroy()
        // bug found it in library it leaks adapter TODO
        imageSlider_movie?.sliderAdapter = null
    }

}