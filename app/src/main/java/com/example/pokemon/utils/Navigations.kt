package com.example.pokemon.utils

import android.app.Activity
import android.content.Intent
import com.example.pokemon.R
import com.example.pokemon.ui.maps.MapsActivity

object Navigations {
    fun goMaps(activity: Activity?){
        activity?.startActivity(Intent(activity,MapsActivity::class.java))
        setAnimationActivity(activity)
    }
    private fun setAnimationActivity (activity: Activity?, typeAnimation: Int? = null) {
        val anim = when(typeAnimation){
            else -> R.anim.fragment_slide_left_enter
        }
        activity?.overridePendingTransition(anim,R.anim.no_animation)
    }
}