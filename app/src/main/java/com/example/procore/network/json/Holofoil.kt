package com.example.example

import com.google.gson.annotations.SerializedName


data class Holofoil (

  @SerializedName("low"       ) var low       : Double? = null,
  @SerializedName("mid"       ) var mid       : Double? = null,
  @SerializedName("high"      ) var high      : Double? = null,
  @SerializedName("market"    ) var market    : Double? = null,
  @SerializedName("directLow" ) var directLow : Double? = null

)