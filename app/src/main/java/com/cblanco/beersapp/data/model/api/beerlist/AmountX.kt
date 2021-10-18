package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class AmountX(
    @SerializedName("unit")
    var unit: String?, // kilograms
    @SerializedName("value")
    var value: Double? // 3.3
)