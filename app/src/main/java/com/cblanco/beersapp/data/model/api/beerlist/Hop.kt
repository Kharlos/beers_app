package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Hop(
    @SerializedName("add")
    var add: String?, // start
    @SerializedName("amount")
    var amount: Amount?,
    @SerializedName("attribute")
    var attribute: String?, // bitter
    @SerializedName("name")
    var name: String? // Fuggles
)