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
import java.lang.StringBuilder

class MoviesViewHolder(val view: View, val listener: MoviesAdapterListener) : RecyclerView.ViewHolder(view) {

    fun bind(movie: Movie) {
        setTitle(movie.title)
        setYear(movie.year.toString())
        setGenre(movie.genres)
        setRating(movie.rating)
        setClickListener(movie)
    }

    private fun setTitle(title: String?) {
        itemView.tv_title?.text = title
    }

    private fun setYear(year: String?) {
        itemView.tv_year?.text = "($year)"
    }

    private fun setGenre(genres: List<String>?) {
        val genreStringBuilder = StringBuilder()
        genres?.let {
            for (_genre in genres) {
                genreStringBuilder.append(_genre)
                genreStringBuilder.append(" ")
            }
            itemView.tv_genre_value?.text = genreStringBuilder
        }
    }

    private fun setRating(rate: Float?) {
        rate?.let {
            itemView.ratingbar?.rating = it
        }
    }

    private fun setClickListener(movie: Movie){
        itemView.setOnClickListener {
            listener.onMovieSelected(movie)
        }
    }
}