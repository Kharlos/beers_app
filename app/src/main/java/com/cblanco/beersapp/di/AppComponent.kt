package com.cblanco.beersapp.di

import android.app.Application
import com.cblanco.beersapp.MainApp
import com.cblanco.beersapp.data.DataModule
import com.cblanco.beersapp.di.builder.framework.MainActivityBuilder
import com.cblanco.beersapp.di.builder.viewmodel.ViewModelBuilder
import com.cblanco.beersapp.ui.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        MainActivityBuilder::class,
        ViewModelBuilder::class
    ]
)
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(app: MainApp)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}