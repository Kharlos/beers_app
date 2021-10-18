package com.cblanco.beersapp.di.builder.framework

import com.cblanco.beersapp.di.builder.viewmodel.BeerDetailViewModelBuilder
import com.cblanco.beersapp.di.builder.viewmodel.BeerListViewModelBuilder
import com.cblanco.beersapp.ui.home.beer.detail.BeerDetailFragment
import com.cblanco.beersapp.ui.home.beer.list.BeerListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            BeerListViewModelBuilder::class
        ]
    )
    abstract fun contibuteBeerListFragment(): BeerListFragment

    @ContributesAndroidInjector(
        modules = [
            BeerDetailViewModelBuilder::class
        ]
    )
    abstract fun contibuteMovieDetailFragment(): BeerDetailFragment
}