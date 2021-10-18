package com.cblanco.beersapp.ui.home.beer.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.databinding.BeerListFragmentBinding
import com.cblanco.beersapp.di.builder.viewmodel.ViewModelFactory
import com.cblanco.beersapp.ui.adapter.BeerListAdapter
import com.cblanco.beersapp.ui.adapter.OnClickBeerItem
import com.cblanco.beersapp.util.extensionfunctions.hideView
import com.cblanco.beersapp.util.extensionfunctions.showView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BeerListFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: BeerListViewModel by viewModels { viewModelFactory }

    private var binding: BeerListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BeerListFragmentBinding.inflate(layoutInflater)
        binding?.apply {
            swiperRefresh.setOnRefreshListener {
                viewModel.getBeerList()
            }
            tvError.hideView()
            dataContainer.hideView()
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.getBeerList()

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.filterByName(p0.toString())
            }
        })
    }

    private fun setObservers() {
        viewModel.progressBar.observe(viewLifecycleOwner, {
            if (it && binding?.swiperRefresh?.isRefreshing == false) {
                binding?.progressBar?.showView()
                binding?.dataContainer?.hideView()
            } else {
                binding?.progressBar?.hideView()
            }
        })
        viewModel.error.observe(viewLifecycleOwner, {
            binding?.dataContainer?.hideView()
            binding?.progressBar?.hideView()
            binding?.tvError?.showView()
            binding?.swiperRefresh?.isRefreshing = false
            binding?.tvError?.text = it
        })

        viewModel.filters.observe(viewLifecycleOwner, {
            populateList(it)
        })

        viewModel.beers.observe(viewLifecycleOwner, {
            populateList(it)
        })
    }

    private fun populateList(beerList: List<BeerUiModel>) {
        binding?.tvError?.hideView()
        binding?.swiperRefresh?.isRefreshing = false
        binding?.dataContainer?.showView()

        binding?.rvBeers?.apply {
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = BeerListAdapter(beerList, object : OnClickBeerItem {
                override fun onClickItem(beerId: Int) {
                    findNavController().navigate(
                        BeerListFragmentDirections.actionBeerListFragmentToBeerDetailFragment(
                            beerId
                        )
                    )
                }
            })
        }
    }

    override fun onStop() {
        super.onStop()
        binding = null
    }

}