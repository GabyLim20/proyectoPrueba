package com.example.pokemon.ui.maps.ui.information

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.pokemon.BaseFragment
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentInformationBinding
import com.example.pokemon.models.DescriptionItem
import com.example.pokemon.utils.Navigations
import com.example.pokemon.utils.load

class InformationFragment : BaseFragment<FragmentInformationBinding>() {

    companion object {
        fun newInstance() = InformationFragment()
    }

    private lateinit var viewModel: InformationViewModel
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInformationBinding = FragmentInformationBinding.inflate(inflater,container,false)

    override fun initViewModel() {
        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
    }

    override fun observers() {
    }

    override fun generalObservers() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.getSerializable("pokemon")as DescriptionItem
        Log.i("pokemon",item.toString())
        binding.textName.text=item.namePokemon
        binding.image.load(item.imagePokemon)
        binding.infoHeight.text = item.height
        binding.infoWeight.text = item.weight
        binding.backButton.setOnClickListener{
            activity?.finish()
            Navigations.goMaps(activity)
        }

    }


}