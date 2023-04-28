package com.example.procore.details

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.procore.network.json.Pokemon

class DetailsViewModel(val pokemon: Pokemon) : ViewModel() {
    // TODO: Implement the ViewModel
}

class DetailViewModelFactory(
    private val pokemon: Pokemon
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(pokemon) as T
    }
}
