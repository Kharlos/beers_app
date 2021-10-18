package com.cblanco.beersapp.usecases

import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.data.repository.BeerRepository
import javax.inject.Inject

class LoadBeerListUseCase@Inject constructor(private val repository: BeerRepository) {

    suspend fun getBeerList():List<BeerUiModel> = repository.getBeerList()

}