package com.cblanco.beersapp.data.datasources

import com.cblanco.beersapp.data.model.ui.BeerUiModel


interface RemoteDataSource {
    suspend fun getBeerList(): List<BeerUiModel>

    //suspend fun getMovieDetail(beerId:Int): RemoteMovieDetail

}