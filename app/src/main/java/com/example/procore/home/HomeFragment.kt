package com.example.procore.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.procore.R
import com.example.procore.databinding.FragmentHomeBinding
import com.example.procore.helper.ItemAdapter
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        var itemAdapter = ItemAdapter(emptyList())

        viewModel.filteredPokemonCards.observe(viewLifecycleOwner) { pokemonList ->
            itemAdapter = ItemAdapter(pokemonList)
            binding.pokemonCardGrid.adapter = itemAdapter
            binding.pokemonCardGrid.layoutManager = GridLayoutManager(requireContext(), 4)
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            viewModel.setChosenType(checkedIds.first())
        }

        viewModel.pokemonTypes.observe(viewLifecycleOwner) {
            it.forEach {type ->

                binding.chipGroupFilter.addView(
                    createChip(type)
                )
            }

        }


        return binding.root
    }

    private fun createChip(chipTitle: String) = Chip(context).apply {
            text = chipTitle
            isChipIconVisible = false
            isCloseIconVisible = false

            // necessary to get single selection working
            isClickable = true
            isCheckable = true
        }
}