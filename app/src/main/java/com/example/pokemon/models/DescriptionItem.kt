package com.example.pokemon.models

import java.io.Serializable

data class DescriptionItem(
    val id: Int,
    val imagePokemon: String,
    val namePokemon: String,
    var description: String,
    val height: String = "",
    val weight: String = ""
): Serializable
