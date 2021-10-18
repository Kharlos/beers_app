package com.cblanco.beersapp.data.datasources

import com.cblanco.beersapp.data.model.api.beerlist.BeerApiResponse
import com.cblanco.beersapp.data.model.ui.BeerUiModel

class ServeBeerDataSource(private val beerRemoteService: BeerRemoteServices) : RemoteDataSource {

    override suspend fun getBeerList(): List<BeerUiModel> {
        val beersResult = beerRemoteService.getBeerList()
        return beersResult.map { remoteBeer: BeerApiResponse ->
            BeerUiModel(
                remoteBeer.id,
                remoteBeer.name,
                remoteBeer.description,
                remoteBeer.imageUrl
            )
        }
    }

    override suspend fun getBeerDetail(beerId: Int): BeerUiModel {
        val apiResult = beerRemoteService.getBeerDetail(beerId).first()
        return BeerUiModel(
            apiResult.id,
            apiResult.name,
            apiResult.description,
            apiResult.imageUrl
        ).apply { degrees = apiResult.abv ?: 0.0 }
    }
}