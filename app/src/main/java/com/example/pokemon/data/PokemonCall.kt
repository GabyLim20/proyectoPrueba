package com.example.pokemon.data

import com.example.pokedex.data.response.PokemonDetailResponse
import com.example.pokemon.api.Configuration
import retrofit2.Call

object PokemonCall {
    fun requestPokemon (id: Int): Call<PokemonDetailResponse> {
        return Configuration.create().requestDetailPokemon(id.toString())

    }
}