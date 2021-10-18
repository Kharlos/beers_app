package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class MashTemp(
    @SerializedName("duration")
    var duration: Int?, // 75
    @SerializedName("temp")
    var temp: TempX?
)