package com.udacity.shoestore.screens.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.User
import com.udacity.shoestore.screens.welcome.WelcomeScreen
import timber.log.Timber

class LoginScreenViewModel : ViewModel() {
    fun login(email : String, password : String) : User? {
        Timber.i("user: email $email, password: $password")
        if (loginDataPlausible(email, password)) {
            Timber.i("creating user...")
            return User(email = email, password = password)
        }
        return null
    }
    private fun loginDataPlausible(email : String, password : String) : Boolean {
        return (email.length > 2 && email.contains("@") && password.length > 2)
    }
}