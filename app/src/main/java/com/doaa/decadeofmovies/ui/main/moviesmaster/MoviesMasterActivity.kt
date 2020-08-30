/*
 * Created by Doaa Fouad on 8/30/20 4:12 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 4:12 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.main.moviesmaster

import com.doaa.decadeofmovies.R
import com.doaa.decadeofmovies.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesMasterActivity : BaseActivity(){

    override val viewModel by viewModel<MoviesMasterViewModel>()
    override val layoutRes = R.layout.activity_movies_master

    override fun initViews() {
    }

}