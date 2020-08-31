/*
 * Created by Doaa Fouad on 8/30/20 3:38 PM
 * Copyright (c) 2020 , Doaa Fouad . All rights reserved.
 * Last modified 8/30/20 3:36 PM
 *
 * Email: doaa_fouad2006@hotmail.com
 * LinkedIn: /doaafouad
 */

package com.doaa.decadeofmovies.ui.base

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.doaa.decadeofmovies.R

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel
    protected abstract val layoutRes: Int //set layout of every activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutRes)
        initViews()
        setClickListeners()
        observeViewModel()
    }

    abstract fun initViews()

    open fun observeViewModel() {}
    open fun setClickListeners() {}
    open fun showProgress() {}
    open fun hideProgress() {}
    open fun error(error: String?) {}

    protected fun navigateToActivity(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    protected fun makeUIFullScreen() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    protected fun showToastMessage(message: String?) {
        val toastMsg = Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG)
        toastMsg?.setText(message)
        toastMsg?.show()
    }
}