package com.cblanco.beersapp.di.builder.viewmodel

import androidx.lifecycle.ViewModel
import com.cblanco.beersapp.di.ViewModelKey
import com.cblanco.beersapp.ui.home.beer.list.BeerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
abstract class BeerListViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(BeerListViewModel::class)
    internal abstract fun bindBeerListViewModel(viewModel: BeerListViewModel): ViewModel

}