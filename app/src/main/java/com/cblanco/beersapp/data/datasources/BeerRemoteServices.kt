package com.cblanco.beersapp.data.datasources

import com.cblanco.beersapp.data.model.api.beerlist.BeerListApiResponse
import retrofit2.http.GET

interface BeerRemoteServices {

    @GET("v2/beers")
    suspend fun getMovieDetail(): List<BeerListApiResponse>


}