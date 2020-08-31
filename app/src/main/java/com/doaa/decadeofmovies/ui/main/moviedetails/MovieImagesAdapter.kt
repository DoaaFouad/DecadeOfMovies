/*
 * Created by Doaa Fouad on 8/31/20 1:18 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 1:18 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.MovieImage
import com.smarteist.autoimageslider.SliderViewAdapter

class MovieImagesAdapter : SliderViewAdapter<MovieImagesViewHolder>() {

    private var movieImagesList: List<MovieImage> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup?): MovieImagesViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie_image, parent, false)

        return MovieImagesViewHolder(view)
    }

    override fun getCount(): Int {
        return movieImagesList.size
    }

    override fun onBindViewHolder(holder: MovieImagesViewHolder, position: Int) {
        holder.bind(movieImagesList[position])
    }

    fun setData(_movieImagesList: List<MovieImage>?) {
        _movieImagesList?.let {
            movieImagesList = _movieImagesList

            notifyDataSetChanged()
        }

    }
}