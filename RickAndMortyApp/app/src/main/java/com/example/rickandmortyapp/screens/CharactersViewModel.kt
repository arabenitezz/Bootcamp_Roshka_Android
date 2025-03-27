package com.example.rickandmortyapp.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repo: CharactersRepository
): ViewModel()  {
    private var currentPage = 1
    private val _state = MutableStateFlow<List<Character>>(emptyList())
    val state : StateFlow<List<Character>> = _state.asStateFlow()

    private var isLoading = false

    init {
        loadCharacter()
    }


    private fun loadCharacter(){
        if (isLoading) return

        viewModelScope.launch {
            isLoading = true
            try {
                val response = repo.getCharacters(currentPage)
                val newCharacter = response.results

                _state.update { previousCharacter ->
                    previousCharacter + newCharacter

                }
                currentPage++
            }catch (e:Exception){
                Log.e("CharacterViewModel", "Error al obtener el personaje",e)
            } finally {
                isLoading = false
            }

        }
    }

}