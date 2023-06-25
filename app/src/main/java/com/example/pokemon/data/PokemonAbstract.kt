package com.example.pokemon.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.pokedex.data.response.PokemonDetailResponse
import retrofit2.Call

abstract class PokemonAbstract {
    abstract fun getPokemon(): LiveData<PokemonDetailResponse>
    abstract fun requestPokemon(context: Context,call: Call<PokemonDetailResponse>)

}