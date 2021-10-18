package com.cblanco.beersapp.data.repository

import com.cblanco.beersapp.data.datasources.RemoteDataSource
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import javax.inject.Inject

class BeerRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getBeerList():List<BeerUiModel> = remoteDataSource.getBeerList()

}