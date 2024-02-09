package com.udacity.shoestore.screens.shoedetail

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.BaseActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.screens.login.LoginScreenViewModel
import timber.log.Timber

class ShoeDetailScreen : Fragment() {

    private lateinit var viewModel: ShoeDetailScreenViewModel
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
        viewModel = ViewModelProvider(this).get(ShoeDetailScreenViewModel::class.java)
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

        viewModel = ViewModelProvider(this).get(ShoeDetailScreenViewModel::class.java)
        binding.btnSave.setOnClickListener {

        }
        binding.btnCancel.setOnClickListener {
            binding.etName.setText("")
            binding.etCompany.setText("")
            binding.etDesc.setText("")
            binding.etSize.setText("")
            findNavController().navigate(R.id.action_shoeDetailScreen_to_shoeListingScreen)
        }
    }


    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}