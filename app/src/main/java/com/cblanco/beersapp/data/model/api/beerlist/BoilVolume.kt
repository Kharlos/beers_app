package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class BoilVolume(
    @SerializedName("unit")
    var unit: String?, // litres
    @SerializedName("value")
    var value: Int? // 25
)