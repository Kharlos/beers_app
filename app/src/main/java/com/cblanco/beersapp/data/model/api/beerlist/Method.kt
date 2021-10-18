package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Method(
    @SerializedName("fermentation")
    var fermentation: Fermentation?,
    @SerializedName("mash_temp")
    var mashTemp: List<MashTemp>?,
    @SerializedName("twist")
    var twist: Any? // null
)