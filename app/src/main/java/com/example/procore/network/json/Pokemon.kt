package com.example.procore.network.json

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon (

  @SerializedName("id"                     ) var id                     : String?                = null,
  @SerializedName("name"                   ) var name                   : String?                = null,
  @SerializedName("images"                 ) var images                 : Images?                = Images(),
  @SerializedName("types"                  ) var types                  : ArrayList<String>      = arrayListOf(),
  /*@SerializedName("supertype"              ) var supertype              : String?                = null,
  @SerializedName("subtypes"               ) var subtypes               : String?                = null,
  @SerializedName("level"                  ) var level                  : String?                = null,
  @SerializedName("hp"                     ) var hp                     : String?                = null,
  @SerializedName("types"                  ) var types                  : ArrayList<String>      = arrayListOf(),
  @SerializedName("evolvesFrom"            ) var evolvesFrom            : String?                = null,
  @SerializedName("abilities"              ) var abilities              : ArrayList<Abilities>   = arrayListOf(),
  @SerializedName("attacks"                ) var attacks                : ArrayList<Attacks>     = arrayListOf(),
  @SerializedName("weaknesses"             ) var weaknesses             : ArrayList<Weaknesses>  = arrayListOf(),
  @SerializedName("resistances"            ) var resistances            : ArrayList<Resistances> = arrayListOf(),
  @SerializedName("retreatCost"            ) var retreatCost            : ArrayList<String>      = arrayListOf(),
  @SerializedName("convertedRetreatCost"   ) var convertedRetreatCost   : Int?                   = null,
  @SerializedName("set"                    ) var set                    : Set?                   = Set(),
  @SerializedName("number"                 ) var number                 : String?                = null,
  @SerializedName("artist"                 ) var artist                 : String?                = null,
  @SerializedName("rarity"                 ) var rarity                 : String?                = null,
  @SerializedName("nationalPokedexNumbers" ) var nationalPokedexNumbers : ArrayList<Int>         = arrayListOf(),
  @SerializedName("legalities"             ) var legalities             : Legalities?            = Legalities(),
  @SerializedName("tcgplayer"              ) var tcgplayer              : Tcgplayer?             = Tcgplayer(),
  @SerializedName("cardmarket"             ) var cardmarket             : Cardmarket?            = Cardmarket()*/

) : Parcelable