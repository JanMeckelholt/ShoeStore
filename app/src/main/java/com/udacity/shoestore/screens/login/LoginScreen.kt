package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.BaseActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import timber.log.Timber


class LoginScreen : Fragment() {

    companion object {
        fun newInstance() = LoginScreen()
    }

    private lateinit var viewModel: LoginScreenViewModel
    private var _binding: FragmentLoginScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

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

        viewModel = ViewModelProvider(this).get(LoginScreenViewModel::class.java)
        binding.btnLogin.setOnClickListener {
            Timber.i("Login clicked...")
            Log.i("test_tag", "Login clicked")
            toWelcomeScreen()
        }
        binding.btnSignUp.setOnClickListener {
            Timber.i("Signup clicked...")
            toWelcomeScreen()
        }
    }

    private fun toWelcomeScreen() {
        val user =
            viewModel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        if (user != null) {
            Timber.i("user: $user")
            findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen)
        } else {
            (activity as? BaseActivity)?.showErrorSnackBar("Password or Email not correct!")
        }
    }

}