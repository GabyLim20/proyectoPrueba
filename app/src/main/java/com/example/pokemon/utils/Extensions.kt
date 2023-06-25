package com.example.pokemon.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pokemon.R

fun ImageView.load(urlImage: String){
    Glide.with(this)
        .load(urlImage)
        .placeholder(R.drawable.mapa)
        .into(this)
}