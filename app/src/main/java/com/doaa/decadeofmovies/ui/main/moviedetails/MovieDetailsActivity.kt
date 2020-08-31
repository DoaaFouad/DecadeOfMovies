/*
 * Created by Doaa Fouad on 8/31/20 12:18 AM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 12:18 AM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviedetails

import android.graphics.Color
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.MovieImage
import com.doaa.decadeofmovies.ui.base.BaseActivity
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : BaseActivity(){

    override val viewModel by viewModel<MovieDetailsViewModel>()
    override val layoutRes = R.layout.activity_movie_details

    private var movieImagesAdapter : MovieImagesAdapter? = null

    private fun initCarousel() {
        movieImagesAdapter = MovieImagesAdapter()
        imageSlider_movie.sliderAdapter = movieImagesAdapter
        imageSlider_movie.setIndicatorAnimation(IndicatorAnimations.WORM)
        imageSlider_movie.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider_movie.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider_movie.scrollTimeInSec = 20
        imageSlider_movie.startAutoCycle()
    }
    private fun setImages(movieImages: List<MovieImage>?){
        movieImagesAdapter?.setData(movieImages)
    }

    override fun initViews() {
    }

}