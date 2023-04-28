package com.example.procore.network

import com.example.procore.network.json.PokemonResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PokemonApi {
    @GET("/v2/cards")
    suspend fun getCards() : Response<PokemonResult>
}