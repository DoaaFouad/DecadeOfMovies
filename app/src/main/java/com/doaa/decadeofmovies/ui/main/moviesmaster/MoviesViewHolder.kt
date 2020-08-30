/*
 * Created by Doaa Fouad on 8/30/20 11:11 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 11:11 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.doaa.decadeofmovies.data.model.Movie
import kotlinx.android.synthetic.main.item_movies_master.view.*

class MoviesViewHolder(val view: View): RecyclerView.ViewHolder(view){

    fun bind(movie: Movie){
        setTitle(movie.title)
        setYear(movie.year)
    }

    private fun setTitle(title: String?){
        itemView.tv_title?.text = title
    }

    private fun setYear(year: String?){
        itemView.tv_year?.text = year
    }
}