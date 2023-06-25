package com.example.pokemon.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedex.data.response.PokemonDescriptionResponse
import com.example.pokedex.data.response.PokemonDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pokemon : PokemonAbstract(){
    private val pokemon = MutableLiveData<PokemonDetailResponse>()
    override fun getPokemon(): LiveData<PokemonDetailResponse> = pokemon

    override fun requestPokemon(context: Context, call: Call<PokemonDetailResponse>) {
        call.enqueue(object : Callback<PokemonDetailResponse>{
            override fun onResponse(
                call: Call<PokemonDetailResponse>,
                response: Response<PokemonDetailResponse>
            ) {
                when (response.code()){
                    200 -> pokemon.value = response.body()
                }
            }

            override fun onFailure(call: Call<PokemonDetailResponse>, t: Throwable) {

            }

        })
    }

}