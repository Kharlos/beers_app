package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Malt(
    @SerializedName("amount")
    var amount: AmountX?,
    @SerializedName("name")
    var name: String? // Maris Otter Extra Pale
)