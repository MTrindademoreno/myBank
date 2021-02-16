@file:Suppress("DEPRECATION")

package com.marciotrindade.mybank.utils

import android.app.Activity
import android.os.Build
import android.view.View
import com.marciotrindade.mybank.R

fun Activity.changeColorStatusBar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val window = this.window
        window.statusBarColor = resources.getColor(R.color.purple_900)
        window.decorView.systemUiVisibility = 0

    }
}

fun Activity.setColorStatusBar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val window = this.window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}