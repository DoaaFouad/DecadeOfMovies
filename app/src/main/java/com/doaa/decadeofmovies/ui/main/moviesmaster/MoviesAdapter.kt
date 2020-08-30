/*
 * Created by Doaa Fouad on 8/30/20 11:08 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 11:08 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.data.model.Movie

class MoviesAdapter() : RecyclerView.Adapter<MoviesViewHolder>() {

    private var moviesList: MutableList<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movies_master, parent, false)

        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    fun setData(_moviesList: MutableList<Movie>) {
        moviesList.clear()
        moviesList = _moviesList
        notifyDataSetChanged()
    }
}