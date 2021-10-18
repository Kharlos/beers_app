package com.cblanco.beersapp.di.builder.viewmodel

import androidx.lifecycle.ViewModel
import com.cblanco.beersapp.di.ViewModelKey
import com.cblanco.beersapp.ui.home.beer.detail.BeerDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
abstract class BeerDetailViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(BeerDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(viewModel: BeerDetailViewModel): ViewModel

}