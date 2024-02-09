package com.udacity.shoestore.screens.login

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.BaseActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import timber.log.Timber


class LoginScreen : Fragment() {

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

    @Deprecated("'onActivityCreated(Bundle?): Unit' is deprecated.")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
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
            toWelcomeScreen()
        }
        binding.btnSignUp.setOnClickListener {
            toWelcomeScreen()
        }
    }

    private fun toWelcomeScreen() {
        activity?.let { hideKeyboard(it) }
        if (!viewModel.login(binding.etName.text.toString(), binding.etEmail.text.toString(), binding.etPassword.text.toString()))
        {
            (activity as? BaseActivity)?.showErrorSnackBar("Password or Email not correct!")
        }
        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                Timber.i("user: $user")
                val bundle = Bundle()
                bundle.putParcelable("user", user)
                findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen, bundle)
            } else {
                Timber.e("user null!!")
                (activity as? BaseActivity)?.showErrorSnackBar("Password or Email not correct!")
            }
        })

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