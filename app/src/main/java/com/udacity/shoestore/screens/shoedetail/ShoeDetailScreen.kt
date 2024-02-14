package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailScreen : Fragment() {
    private var _binding: FragmentShoeDetailScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShoeDetailScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    @Deprecated("'onActivityCreated(Bundle?): Unit' is deprecated.")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated")
        binding.btnSave.setOnClickListener {
            Timber.i("Size: ${binding.etSize.text}")
            val shoe = Shoe(
                name = if (binding.etName.text.isBlank()) "- not set -" else binding.etName.text.toString(),
                company = if (binding.etCompany.text.isBlank()) "- not set -" else binding.etCompany.text.toString(),
                description = if (binding.etDesc.text.isBlank()) "- not set -" else binding.etDesc.text.toString(),
                size = if (binding.etSize.text.isBlank()) 0.0 else binding.etSize.text.toString().toDouble()
            )
            val bundle = Bundle()
            bundle.putParcelable("shoe", shoe)
            findNavController().navigate(R.id.action_shoeDetailScreen_to_shoeListingScreen, bundle)
        }
        binding.btnCancel.setOnClickListener {
            binding.etName.setText("")
            binding.etCompany.setText("")
            binding.etDesc.setText("")
            binding.etSize.setText("")
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}