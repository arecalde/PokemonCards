package com.example.procore.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.procore.network.RetrofitHelper
import com.example.procore.network.json.Pokemon
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _pokemonCards = MutableLiveData<List<Pokemon>>()
    val pokemonCards: LiveData<List<Pokemon>>
        get() = _pokemonCards

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    init {
        viewModelScope.launch {
            _loading.value = true
            _pokemonCards.value = RetrofitHelper.getPokemonCards()?.data?.toList()
            _loading.value = false
        }
    }

    fun sortCardsByType() {
        _pokemonCards.value = _pokemonCards.value?.sortedBy { it.types.first() }
    }
}