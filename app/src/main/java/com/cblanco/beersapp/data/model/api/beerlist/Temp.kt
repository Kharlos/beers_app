package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("unit")
    var unit: String?, // celsius
    @SerializedName("value")
    var value: Int? // 19
)