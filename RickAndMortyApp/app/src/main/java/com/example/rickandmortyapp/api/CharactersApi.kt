package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.model.CharactersList
import retrofit2.http.GET

interface CharactersApi {
    @GET("character")
    suspend fun getCharacters(): CharactersList
}