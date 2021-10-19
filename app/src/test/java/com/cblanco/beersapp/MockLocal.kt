package com.cblanco.beersapp

import com.cblanco.beersapp.data.model.api.beerlist.*
import com.cblanco.beersapp.data.model.ui.BeerUiModel

fun getBeerRemoteInstance(beerName:String) = BeerApiResponse(
    2.2, 0.0, BoilVolume("", 1),
    "", "", "", 0, "", listOf(), 0.0, 0, "",
    Ingredients(listOf(), listOf(), ""), Method(Fermentation(Temp("", 0)), listOf(), 1), beerName,
    0.0, 0.0, "", 0, 0.0, Volume("", 0)
)

fun getBeerUiModelInstance(beerName:String) = BeerUiModel(1, beerName, "", "")