package com.example.pokemon

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

abstract class BaseActivity (private val type: Int? = 0): AppCompatActivity() {
    companion object{
        const val FULL_SCREEN = 0
        const val WHITE = 1
        const val TRANSPARENT = 2
        const val BLUE = 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when(type) {
            FULL_SCREEN -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN
                    )
                }
            }
            WHITE->{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    window?.statusBarColor = ContextCompat.getColor(this, R.color.white)
                    window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
            TRANSPARENT-> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    )
                }
            }
            BLUE -> {
                window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
                window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

}