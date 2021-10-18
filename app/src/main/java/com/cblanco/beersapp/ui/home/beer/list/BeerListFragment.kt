package com.cblanco.beersapp.ui.home.beer.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cblanco.beersapp.databinding.BeerListFragmentBinding
import com.cblanco.beersapp.di.builder.viewmodel.ViewModelFactory
import com.cblanco.beersapp.ui.adapter.BeerListAdapter
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
            rvBeers.hideView()
            rvBeers.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
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
    }

    private fun setObservers() {
        viewModel.progressBar.observe(viewLifecycleOwner, {
            if(it){
                binding?.progressBar?.showView()
                binding?.rvBeers?.hideView()
            }else{
                binding?.progressBar?.hideView()
            }
        })
        viewModel.beers.observe(viewLifecycleOwner, {
            binding?.rvBeers?.apply {
                this.showView()
                adapter = BeerListAdapter(it)
            }
        })
    }

    override fun onStop() {
        super.onStop()
        binding = null
    }

}