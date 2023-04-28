package com.example.procore.network.json

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images (

  @SerializedName("small" ) var small : String? = null,
  @SerializedName("large" ) var large : String? = null

) : Parcelable