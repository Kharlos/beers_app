package com.cblanco.beersapp.util.extensionfunctions

import android.view.View

fun View.hideView() {
    this.visibility = View.GONE
}

fun View.showView() {
    this.visibility = View.VISIBLE
}