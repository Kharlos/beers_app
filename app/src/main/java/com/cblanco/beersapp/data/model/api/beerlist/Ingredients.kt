package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("hops")
    var hops: List<Hop>?,
    @SerializedName("malt")
    var malt: List<Malt>?,
    @SerializedName("yeast")
    var yeast: String? // Wyeast 1056 - American Ale™
)