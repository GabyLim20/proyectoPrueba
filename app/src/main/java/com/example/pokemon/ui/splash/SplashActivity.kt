package com.example.pokemon.ui.splash

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.pokemon.BaseActivity
import com.example.pokemon.R
import com.example.pokemon.databinding.ActivitySplashBinding
import com.example.pokemon.utils.Navigations

class SplashActivity : BaseActivity(TRANSPARENT){
    private lateinit var binding: ActivitySplashBinding
    private val animationFadeIn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fade_in) }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        playgit()

    }
    private fun playgit(){
        Glide.with(this).asGif().load(R.drawable.pokebola).into(binding.imageSplash)
        Handler(Looper.getMainLooper()).postDelayed({
            allRightPermission()
        }, 2500)
    }


    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
        it.forEach {
            if(!it.value){
                Toast.makeText(this,"Requiere permisos para la ubicación", Toast.LENGTH_SHORT).show()
                requirePermissionAgain()
                return@registerForActivityResult
            }
        }
        Navigations.goMaps(this)
        finish()
    }
    private fun allRightPermission(){
        when (PackageManager.PERMISSION_GRANTED){
            this?.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                Navigations.goMaps(this)
                finish()
            }
            else -> { requestPermission.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)) }
        }
    }
    private fun requirePermissionAgain(){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply{
            data = Uri.fromParts("package",this@SplashActivity.packageName,null)
        }
        this?.startActivity(intent)
    }


}