package com.example.procore.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.procore.R
import com.example.procore.databinding.FragmentHomeBinding
import com.example.procore.helper.ItemAdapter

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.pokemonCards.observe(viewLifecycleOwner) {
            binding.pokemonCardGrid.adapter = ItemAdapter(it)
            binding.pokemonCardGrid.layoutManager = GridLayoutManager(requireContext(), 4)
        }

        return binding.root
    }
}