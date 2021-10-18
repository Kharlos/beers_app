package com.cblanco.beersapp.ui.home.beer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cblanco.beersapp.databinding.BeerDetailFragmentBinding
import com.cblanco.beersapp.di.builder.viewmodel.ViewModelFactory
import com.cblanco.beersapp.util.extensionfunctions.hideView
import com.cblanco.beersapp.util.extensionfunctions.loadImgFromUrl
import com.cblanco.beersapp.util.extensionfunctions.showView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BeerDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BeerDetailViewModel by viewModels { viewModelFactory }
    private var binding: BeerDetailFragmentBinding? = null
    private val args: BeerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BeerDetailFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.loadBeerDetail(args.beerId)
    }

    private fun setupObservers() {
        viewModel.progressBar.observe(viewLifecycleOwner, {
            if (it) {
                binding?.progressBar?.showView()
            } else {
                binding?.progressBar?.hideView()
            }
        })

        viewModel.error.observe(viewLifecycleOwner, { errorDetail ->
            binding?.let {
                it.groupContainer.hideView()
                it.progressBar.hideView()
                it.tvError.showView()
                it.tvError.text = errorDetail
            }
        })

        viewModel.beerDetail.observe(viewLifecycleOwner, { beerUiMoidel ->
            binding?.let {
                it.tvError.hideView()
                it.groupContainer.showView()
                it.ivBeerImg.loadImgFromUrl(beerUiMoidel.image_url ?: "")
                it.progressBar.hideView()
                it.tvBeerName.text = beerUiMoidel.name
                it.tvBeerDescription.text = beerUiMoidel.description
                it.tvGrades.text = "Grados: ${beerUiMoidel.degrees}°"
            }
        })
    }

    override fun onStop() {
        super.onStop()
        binding = null
    }


}