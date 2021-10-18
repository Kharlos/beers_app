package com.cblanco.beersapp.data.datasources

import com.cblanco.beersapp.data.model.api.beerlist.BeerApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerRemoteServices {

    @GET("v2/beers")
    suspend fun getBeerList(): List<BeerApiResponse>

    @GET("v2/beers/{beerId}")
    suspend fun getBeerDetail(@Path("beerId") beerId: Int): List<BeerApiResponse>


}