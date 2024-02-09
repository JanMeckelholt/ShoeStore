package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding
import timber.log.Timber

class ShoeListingScreen : Fragment() {

    private lateinit var viewModel: ShoeListingScreenViewModel
    private var _binding: FragmentShoeListingScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShoeListingScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    @Deprecated("'onActivityCreated(Bundle?): Unit' is deprecated.")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
        handleViewCreated()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated")
        handleViewCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun handleViewCreated() {
        viewModel = ViewModelProvider(this).get(ShoeListingScreenViewModel::class.java)
        binding.btnToShoeDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingScreen_to_shoeDetailScreen)
        }

    }
}