package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding
import timber.log.Timber

class WelcomeScreen : Fragment() {

    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding!!

    private val args: WelcomeScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        if (args.user != null) {
            Toast.makeText(this@WelcomeScreen.context,"Welcome ${args.user!!.name}!", Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    @Deprecated("'onActivityCreated(Bundle?): Unit' is deprecated.")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated")
        binding.btnToInstructions.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreen_to_instructionsScreen)
        }
    }


}