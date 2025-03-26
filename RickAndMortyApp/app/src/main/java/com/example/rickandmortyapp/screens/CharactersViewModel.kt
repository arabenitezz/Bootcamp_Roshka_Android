package com.example.rickandmortyapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repo: CharactersRepository
): ViewModel()  {
    private val _state = MutableStateFlow(emptyList<Character>())
    val state : StateFlow<List<Character>>
        get() = _state

    init {
        viewModelScope.launch {
            _state.value = repo.getCharacters().characters
        }
    }
}