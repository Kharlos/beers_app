package com.cblanco.beersapp.data

import com.cblanco.beersapp.data.datasources.RemoteDataSource
import com.cblanco.beersapp.data.repository.BeerRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun movieRepositoryProvider(
        remoteDataSource: RemoteDataSource
    )
            : BeerRepository = BeerRepository(remoteDataSource)


}