package com.example.procore.network.json

import com.google.gson.annotations.SerializedName


data class PokemonResult (

  @SerializedName("data"       ) var data       : ArrayList<Pokemon> = arrayListOf(),
  @SerializedName("page"       ) var page       : Int?            = null,
  @SerializedName("pageSize"   ) var pageSize   : Int?            = null,
  @SerializedName("count"      ) var count      : Int?            = null,
  @SerializedName("totalCount" ) var totalCount : Int?            = null

)