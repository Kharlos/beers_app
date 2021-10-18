package com.cblanco.beersapp.data.datasources

import android.graphics.Movie
import com.cblanco.beersapp.data.model.api.beerlist.BeerListApiResponse
import com.cblanco.beersapp.data.model.ui.BeerUiModel

class ServeBeerDataSource(private val beerRemoteService: BeerRemoteServices) : RemoteDataSource  {

    override suspend fun getBeerList(): List<BeerUiModel> {
        val beersResult = beerRemoteService.getMovieDetail()
        return beersResult.map { remoteBeer: BeerListApiResponse ->
            BeerUiModel(
                remoteBeer.id,
                remoteBeer.name,
                remoteBeer.description,
                remoteBeer.imageUrl
            )
        }
    }
}