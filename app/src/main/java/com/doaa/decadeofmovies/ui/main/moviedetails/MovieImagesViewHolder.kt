/*
 * Created by Doaa Fouad on 8/31/20 1:18 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/31/20 1:18 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviedetails

import android.view.View
import com.bumptech.glide.Glide
import com.doaa.decadeofmovies.data.model.MovieImage
import com.doaa.decadeofmovies.utils.getFullUrl
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_movie_image.view.*

class MovieImagesViewHolder(val itemView: View) : SliderViewAdapter.ViewHolder(itemView) {

    fun bind(image: MovieImage?) {
        itemView.context?.let {
            Glide.with(it.applicationContext)
                .load(image?.getFullUrl())
                .into(itemView.iv_movie_image)
        }
    }
}