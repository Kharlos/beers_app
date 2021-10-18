package com.cblanco.beersapp.util.extensionfunctions

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cblanco.beersapp.R

fun AppCompatImageView.loadImgFromUrl(imageUrl:String){
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(this.context)
            .load(imageUrl)
            .placeholder(ColorDrawable(this.context.getColor(R.color.place_holder)))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}