package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.model.CharactersList
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {
    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): CharactersList
}