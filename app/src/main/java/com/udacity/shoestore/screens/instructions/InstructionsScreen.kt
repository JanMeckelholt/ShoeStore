package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R

class InstructionsScreen : Fragment() {

    companion object {
        fun newInstance() = InstructionsScreen()
    }

    private lateinit var viewModel: InstructionsScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instructions_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InstructionsScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}