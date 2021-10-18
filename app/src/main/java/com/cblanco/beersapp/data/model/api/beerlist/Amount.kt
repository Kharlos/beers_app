package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Amount(
    @SerializedName("unit")
    var unit: String?, // grams
    @SerializedName("value")
    var value: Double? // 25.5
)