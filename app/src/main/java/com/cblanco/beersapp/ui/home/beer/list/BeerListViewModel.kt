package com.cblanco.beersapp.ui.home.beer.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.usecases.LoadBeerUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BeerListViewModel @Inject constructor(private val loadBeerUseCase: LoadBeerUseCase) :
    ViewModel() {
    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> = _progressBar

    private val _beers = MutableLiveData<List<BeerUiModel>>()
    val beers: LiveData<List<BeerUiModel>> = _beers

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _filters = MutableLiveData<List<BeerUiModel>>()
    var filters: MutableLiveData<List<BeerUiModel>> = _filters
    var allBeers: List<BeerUiModel>? = null


    fun getBeerList() {
        val handlerError = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
            _error.postValue("Ups ha ocurrido un error.")
        }
        viewModelScope.launch(Dispatchers.IO + handlerError) {
            _progressBar.postValue(true)
            allBeers = loadBeerUseCase.getBeerList()
            if (allBeers?.isNotEmpty() == true) {
                _beers.postValue(allBeers!!)
            } else
                _error.postValue("No se han podido cargar las Cervezas.")
            _progressBar.postValue(false)
        }
    }

    fun filterByName(query: String) {
        allBeers?.let { list ->
            if (!query.isBlank()) {
                _filters.value = list.filter { it.name?.contains(query, true) ?: false }
            } else {
                _filters.value = list
            }
        }
    }
}