package com.example.example

import com.google.gson.annotations.SerializedName


data class Tcgplayer (

  @SerializedName("url"       ) var url       : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null,
  @SerializedName("prices"    ) var prices    : Prices? = Prices()

)