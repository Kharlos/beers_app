package com.cblanco.beersapp.ui.home.beer.detail

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

class BeerDetailViewModel @Inject constructor(private val loadBeerUseCase: LoadBeerUseCase) :
    ViewModel() {

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> = _progressBar

    private val _beerDetail = MutableLiveData<BeerUiModel>()
    val beerDetail: LiveData<BeerUiModel> = _beerDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadBeerDetail(beerId: Int) {
        val handlerError = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
            _error.postValue("Ha ocurrido un error al intentar cargar la información de la cerveza.")
        }
        viewModelScope.launch(Dispatchers.IO + handlerError) {
            _progressBar.postValue(true)
            _beerDetail.postValue(loadBeerUseCase.getBeerDetail(beerId))
            _progressBar.postValue(false)
        }
    }

}