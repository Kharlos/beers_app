package com.cblanco.beersapp.data.model.api.beerlist


import com.google.gson.annotations.SerializedName

data class BeerApiResponse(
    @SerializedName("abv")
    var abv: Double?, // 4.5
    @SerializedName("attenuation_level")
    var attenuationLevel: Double?, // 75
    @SerializedName("boil_volume")
    var boilVolume: BoilVolume?,
    @SerializedName("brewers_tips")
    var brewersTips: String?, // The earthy and floral aromas from the hops can be overpowering. Drop a little Cascade in at the end of the boil to lift the profile with a bit of citrus.
    @SerializedName("contributed_by")
    var contributedBy: String?, // Sam Mason <samjbmason>
    @SerializedName("description")
    var description: String?, // A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.
    @SerializedName("ebc")
    var ebc: Int?, // 20
    @SerializedName("first_brewed")
    var firstBrewed: String?, // 09/2007
    @SerializedName("food_pairing")
    var foodPairing: List<String>?,
    @SerializedName("ibu")
    var ibu: Double?, // 60
    @SerializedName("id")
    var id: Int?, // 1
    @SerializedName("image_url")
    var imageUrl: String?, // https://images.punkapi.com/v2/keg.png
    @SerializedName("ingredients")
    var ingredients: Ingredients?,
    @SerializedName("method")
    var method: Method?,
    @SerializedName("name")
    var name: String?, // Buzz
    @SerializedName("ph")
    var ph: Double?, // 4.4
    @SerializedName("srm")
    var srm: Double?, // 10
    @SerializedName("tagline")
    var tagline: String?, // A Real Bitter Experience.
    @SerializedName("target_fg")
    var targetFg: Int?, // 1010
    @SerializedName("target_og")
    var targetOg: Double?, // 1044
    @SerializedName("volume")
    var volume: Volume?
)