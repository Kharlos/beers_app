package com.cblanco.beersapp.ui.home.beer.list


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cblanco.beersapp.ApiClient
import com.cblanco.beersapp.data.datasources.BeerRemoteServices
import com.cblanco.beersapp.data.datasources.ServeBeerDataSource
import com.cblanco.beersapp.data.model.api.beerlist.BeerApiResponse
import com.cblanco.beersapp.data.repository.BeerRepository
import com.cblanco.beersapp.getBeerRemoteInstance
import com.cblanco.beersapp.getBeerUiModelInstance
import com.cblanco.beersapp.testObserver
import com.cblanco.beersapp.usecases.LoadBeerUseCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class BeerListViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var loadBeerUseCase: LoadBeerUseCase
    private lateinit var beerRepository: BeerRepository
    private lateinit var beerListViewModel: BeerListViewModel
    val beerRemoteService = mock(BeerRemoteServices::class.java)

    val beerList =
        arrayListOf<BeerApiResponse>(
            getBeerRemoteInstance("Corona"),
            getBeerRemoteInstance("Polar"),
            getBeerRemoteInstance("Callao"),
            getBeerRemoteInstance("Presidente")
        )

    @Before
    fun setUp() {

        beerRepository = BeerRepository(ServeBeerDataSource(beerRemoteService))
        loadBeerUseCase = LoadBeerUseCase(beerRepository)
        beerListViewModel = BeerListViewModel(loadBeerUseCase)
        val apiClient = mock(ApiClient::class.java)

        `when`(apiClient.create(BeerRemoteServices::class, BeerRemoteServices::getBeerList))
            .thenReturn(beerRemoteService)

        runBlocking {
            `when`(beerRemoteService.getBeerList())
                .thenReturn(
                    beerList
                )
        }
    }


    @Test
    fun testGetBeerList() {

        runBlocking {

            val testObserver = beerListViewModel.beers.testObserver()
            testObserver.observedValues.clear()

            beerListViewModel.getBeerList()
            verify(beerRemoteService).getBeerList()

            val value = testObserver.observedValues.first()?.size
            assertThat(value, `is`(4))
        }

    }
    @Test
    fun `test filter`() {

        runBlocking {

            val testObserver = beerListViewModel.filters.testObserver()
            testObserver.observedValues.clear()

            beerListViewModel.allBeers = listOf(getBeerUiModelInstance("Polar"), getBeerUiModelInstance("Callao"))
            beerListViewModel.filterByName("Ca")

            val value = testObserver.observedValues.first()?.size
            assertThat(value, `is`(1))
        }

    }

}