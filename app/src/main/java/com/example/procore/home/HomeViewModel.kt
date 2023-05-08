package com.example.procore.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.procore.helper.ItemAdapter
import com.example.procore.network.RetrofitHelper
import com.example.procore.network.json.Pokemon
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _pokemonTypes = MutableLiveData(setOf<String>())
    val pokemonTypes: LiveData<Set<String>>
        get() = _pokemonTypes

    private var pokemonCards: List<Pokemon>? = null

    private val _filteredPokemonCards = MutableLiveData<List<Pokemon>>()
    val filteredPokemonCards: LiveData<List<Pokemon>>
        get() = _filteredPokemonCards

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _chosenType = MutableLiveData<Int>()
    val chosenType: LiveData<Int>
        get() = _chosenType

    init {
        viewModelScope.launch {
            _loading.value = true
            pokemonCards = RetrofitHelper.getPokemonCards()?.data?.toList()
            _filteredPokemonCards.value = pokemonCards ?: return@launch
            val setOfTypes = mutableSetOf<String>()
            pokemonCards?.forEach { pokemon ->
                pokemon.types.forEach { type ->
                    setOfTypes.add(type)
                }
            }
            _pokemonTypes.value = setOfTypes

            _loading.value = false
        }
    }

    fun setChosenType(newType: Int) {
        _chosenType.value = newType
        val setOfTypes = pokemonTypes.value ?: return
        val type = setOfTypes.toList()[newType-1]
        pokemonCards?.let { pokemonCards ->
            val filteredCards =
                pokemonCards.filter {
                    it.types.contains(type)
                }
            _filteredPokemonCards.value = filteredCards
        }
    }
    fun sortCardsByType() {
        _filteredPokemonCards.value = pokemonCards?.sortedBy { it.types.first() }
    }
}