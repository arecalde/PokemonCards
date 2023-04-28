package com.example.example

import com.google.gson.annotations.SerializedName


data class Attacks (

  @SerializedName("name"                ) var name                : String?           = null,
  @SerializedName("cost"                ) var cost                : ArrayList<String> = arrayListOf(),
  @SerializedName("convertedEnergyCost" ) var convertedEnergyCost : Int?              = null,
  @SerializedName("damage"              ) var damage              : String?           = null,
  @SerializedName("text"                ) var text                : String?           = null

)