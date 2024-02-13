package com.udacity.shoestore.screens.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding
import timber.log.Timber


class ShoeListingScreen : Fragment(), MenuProvider {

    private lateinit var viewModel: ShoeListingScreenViewModel
    private var _binding: FragmentShoeListingScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var shoeAdapter: ShoeAdapter
    private val args: ShoeListingScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShoeListingScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return view
    }

    @Deprecated("'onActivityCreated(Bundle?): Unit' is deprecated.")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated")
        viewModel = ViewModelProvider(this).get(ShoeListingScreenViewModel::class.java)
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            Timber.i("num of shoes:  ${shoes.size}")
            shoeAdapter = ShoeAdapter(shoes, this.requireContext(), viewModel)
            binding.lvShoes.layoutManager = LinearLayoutManager(context)
            binding.lvShoes.adapter = shoeAdapter
        })
        if (args.shoe != null) {
            viewModel.addShoe(args.shoe!!)
        }
        binding.btnToShoeDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingScreen_to_shoeDetailScreen)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.loginScreen -> {
                findNavController().navigate(R.id.action_shoeListingScreen_to_loginScreen)
                return true
            }
            else -> return false
        }
    }
}