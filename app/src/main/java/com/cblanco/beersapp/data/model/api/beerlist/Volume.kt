package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Volume(
    @SerializedName("unit")
    var unit: String?, // litres
    @SerializedName("value")
    var value: Int? // 20
)