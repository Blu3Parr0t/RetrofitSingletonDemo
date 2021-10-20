package com.example.retrofitsingetondemo.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitsingetondemo.R
import com.example.retrofitsingetondemo.data.network.repo.HearthStoneRepo
import com.example.retrofitsingetondemo.databinding.FragmentHomeScreenBinding
import com.example.retrofitsingetondemo.ui.homescreen.adapter.ClassesAdapter
import com.example.retrofitsingetondemo.util.createViewModel

class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel: HomeScreenViewModel by lazy {
        createViewModel {
            HomeScreenViewModel(
                app = this.requireActivity().application,
                HearthStoneRepo.provideHeartStoneRepo()
            )
        }
    }
    private lateinit var adapter: ClassesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = ClassesAdapter()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen, container, false)
        binding.lifecycleOwner = this
        binding.homeScreenRV.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.homeScreenRV.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservables()
        viewModel.fetchClassList()
    }

    private fun setUpObservables() {
        viewModel.heartStoneClasses.observe(viewLifecycleOwner, { responseList ->
            adapter.setData(responseList)
        })
    }
}
