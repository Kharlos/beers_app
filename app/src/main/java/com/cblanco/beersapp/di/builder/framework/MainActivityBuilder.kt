package com.cblanco.beersapp.di.builder.framework

import com.cblanco.beersapp.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )

    internal abstract fun bindMainActivity(): MainActivity

}