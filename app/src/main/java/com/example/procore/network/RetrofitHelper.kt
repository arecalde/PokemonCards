package com.example.procore.network

import com.example.procore.network.json.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseUrl = "https://api.pokemontcg.io"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun getPokemonCards(): PokemonResult? = withContext(Dispatchers.IO) {
        val apiService = getInstance().create(PokemonApi::class.java)
        val call = apiService.getCards()

        call.body()

    }
}