package com.example.example

import com.google.gson.annotations.SerializedName


data class Abilities (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("text" ) var text : String? = null,
  @SerializedName("type" ) var type : String? = null

)