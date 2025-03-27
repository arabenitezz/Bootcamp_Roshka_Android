package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.api.CharactersApi
import com.example.rickandmortyapp.model.CharactersList
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: CharactersApi) {
    suspend fun getCharacters(page: Int): CharactersList = api.getCharacter(page)
}