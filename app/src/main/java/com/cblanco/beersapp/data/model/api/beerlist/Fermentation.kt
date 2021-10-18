package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Fermentation(
    @SerializedName("temp")
    var temp: Temp?
)