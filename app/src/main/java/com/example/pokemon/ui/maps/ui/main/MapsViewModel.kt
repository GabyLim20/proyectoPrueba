package com.example.pokemon.ui.maps.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.response.PokemonDetailResponse
import com.example.pokemon.data.PokemonCall

class MapsViewModel : ViewModel() {
    private val pokemon = com.example.pokemon.data.Pokemon()
    fun getPokemon(): LiveData<PokemonDetailResponse> = pokemon.getPokemon()
    fun requestPokemon(id: Int, context: Context){
        pokemon.requestPokemon(context,PokemonCall.requestPokemon(id))
    }
}