package com.example.pokemon.ui.maps.ui.gif

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.pokemon.BaseFragment
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentGifBinding
import com.example.pokemon.models.DescriptionItem
import com.example.pokemon.utils.Navigations

class GifFragment : BaseFragment<FragmentGifBinding>() {

    companion object {
        fun newInstance() = GifFragment()
    }

    private lateinit var viewModel: GifViewModel
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGifBinding = FragmentGifBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.getSerializable("pokemon")as DescriptionItem
        val bundle = Bundle()
        bundle.putSerializable("pokemon",item)
        playgit()
        Handler(Looper.getMainLooper()).postDelayed({
            view.findNavController().navigate(R.id.action_gifFragment_to_informationFragment, bundle)
        }, 3500)
    }


    override fun initViewModel() {
        viewModel = ViewModelProvider(this).get(GifViewModel::class.java)
    }

    override fun observers() {
    }

    override fun generalObservers() {
    }
    private fun playgit(){
        Glide.with(this).asGif().load(R.drawable.spokebola).into(binding.imageGif)

    }



}