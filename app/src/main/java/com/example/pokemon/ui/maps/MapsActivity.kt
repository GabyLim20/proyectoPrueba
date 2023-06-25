package com.example.pokemon.ui.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.pokemon.BaseActivity
import com.example.pokemon.R
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.databinding.ActivityMapsBinding
import com.example.pokemon.ui.maps.ui.main.MapsFragment

class MapsActivity : BaseActivity(){
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            val final = NavHostFragment.create(R.navigation.maps)
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, final)
                .commit()
        }
    }

}