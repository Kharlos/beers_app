package com.cblanco.beersapp.ui.home.beer.list

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.usecases.LoadBeerListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BeerListViewModel @Inject constructor(private val loadBeerListUseCase: LoadBeerListUseCase) : ViewModel() {
    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> = _progressBar

    private val _beers = MutableLiveData<List<BeerUiModel>>()
    val beers: LiveData<List<BeerUiModel>> = _beers

    private val _filters = MutableLiveData<List<BeerUiModel>>()
    var filters: MutableLiveData<List<BeerUiModel>> = _filters


    fun getBeerList() {
        val handlerError = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(Dispatchers.IO + handlerError) {
            _progressBar.postValue(true)
            _beers.postValue(loadBeerListUseCase.getBeerList())
            _progressBar.postValue(false)
        }
    }
}