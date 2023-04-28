package com.example.example

import com.google.gson.annotations.SerializedName


data class Weaknesses (

  @SerializedName("type"  ) var type  : String? = null,
  @SerializedName("value" ) var value : String? = null

)