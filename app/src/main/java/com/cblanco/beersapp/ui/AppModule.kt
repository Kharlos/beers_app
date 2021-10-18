package com.cblanco.beersapp.ui

import android.app.Application
import android.content.Context
import com.cblanco.beersapp.data.datasources.BeerRemoteServices
import com.cblanco.beersapp.data.datasources.RemoteDataSource
import com.cblanco.beersapp.data.datasources.ServeBeerDataSource
import com.cblanco.beersapp.di.MainActivityComponent
import com.cblanco.beersapp.util.RETROFIT_TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(subcomponents = [MainActivityComponent::class])
class AppModule {

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        )
        .build()

    @Provides
    @Singleton
    fun beerRemoteServiceProvider(retrofit: Retrofit): BeerRemoteServices =
        retrofit.create(BeerRemoteServices::class.java)

    @Provides
    fun remoteDataSourceProvider(movieRemoteService: BeerRemoteServices): RemoteDataSource =
        ServeBeerDataSource(movieRemoteService)


}
