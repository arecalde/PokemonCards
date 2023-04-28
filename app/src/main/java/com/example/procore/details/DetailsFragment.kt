package com.example.procore.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.procore.R
import com.example.procore.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModels {
        DetailViewModelFactory(args.pokemon)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DetailsFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}