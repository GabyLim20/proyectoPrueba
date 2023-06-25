package com.example.pokemon.ui.maps.ui.main

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.pokemon.BaseFragment
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentMainBinding
import com.example.pokemon.models.DescriptionItem
import com.example.pokemon.utils.dialogs.ModalDialogFragment
import kotlin.random.Random

class MapsFragment : BaseFragment< FragmentMainBinding>(), LocationListener {

    companion object {
        fun newInstance() = MapsFragment()
    }

    private lateinit var viewModel: MapsViewModel
    private var distance = 0.0
    private var ubication: Location? = null
    private lateinit var locationListener: LocationManager

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSee.setOnClickListener {
            viewModel.requestPokemon(NumRandom(),requireContext())
        }
        findMyLocation()

    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MapsViewModel::class.java)
    }

    override fun observers() {
        viewModel.getPokemon().observe(viewLifecycleOwner){
            val item = DescriptionItem(
                it.id,
                it.sprites.imagePokemon,
                it.name, "",
                it.height.toString(),
                it.weight.toString())
            val bundle = Bundle()
            bundle.putSerializable("pokemon",item)
            view?.findNavController()?.navigate(R.id.action_mapsFragment_to_gifFragment, bundle)
        }
    }

    override fun generalObservers() {

    }
    private fun findMyLocation() {
        locationListener = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationListener.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0F, this)
        }

    }
    override fun onPause() {
        super.onPause()
        locationListener.removeUpdates(this)
    }
    override fun onResume() {
        super.onResume()
        findMyLocation()
    }

    override fun onDestroy() {
        super.onDestroy()
        locationListener.removeUpdates(this)
    }

    override fun onLocationChanged(location: Location) {
        if (ubication != null) {
            distance = location.distanceTo(ubication!!).toDouble()
            binding.textMts.text = "${distance.toInt()} mts"
            validation()
            return
        }

        ubication = location
    }

    private fun validation() {
        if (distance == 0.0) return

        if (distance >= 10) {
            viewModel.requestPokemon(NumRandom(),requireContext())
            distance = 0.0
            ubication = null
        }
    }
    private fun NumRandom(): Int {
        return Random.nextInt(0, 100)
    }

}