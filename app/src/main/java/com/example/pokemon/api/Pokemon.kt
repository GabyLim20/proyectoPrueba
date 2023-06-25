package com.example.pokemon.api

import com.example.pokedex.data.response.PokemonDescriptionResponse
import com.example.pokedex.data.response.PokemonDetailResponse
import com.example.pokedex.data.response.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Pokemon {
    @GET("pokemon/")
    fun requestPokemon(): Call<PokemonListResponse>

    @GET("pokemon/{namePokemon}/")
    fun requestDetailPokemon(
        @Path("namePokemon") namePokemon: String
    ): Call<PokemonDetailResponse>

    @GET("characteristic/{idPokemon}/")
    fun requestDescriptionPokemon(
        @Path("idPokemon") idPokemon: String
    ): Call<PokemonDescriptionResponse>
}