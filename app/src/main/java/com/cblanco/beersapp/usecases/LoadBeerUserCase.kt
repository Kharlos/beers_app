package com.cblanco.beersapp.usecases

import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.data.repository.BeerRepository
import javax.inject.Inject

class LoadBeerUseCase @Inject constructor(private val repository: BeerRepository) {

    suspend fun getBeerList():List<BeerUiModel> = repository.getBeerList()

    suspend fun getBeerDetail(beerId:Int):BeerUiModel = repository.getBeerDetail(beerId)

}