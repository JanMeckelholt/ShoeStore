package com.udacity.shoestore.screens.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.User
import timber.log.Timber

class LoginScreenViewModel : ViewModel() {

    var user = MutableLiveData<User>()
    fun login(name: String, email : String, password : String) :Boolean {
        Timber.i("user $name: email $email, password: $password")
        if (loginDataPlausible(name, email, password)) {
            Timber.i("creating user...")
            user = MutableLiveData(User(name= name, email=email, password = password))
            return true
        }
        return false
    }
    private fun loginDataPlausible(name: String, email : String, password : String) : Boolean {
        return (name.length > 2 &&email.length > 2 && email.contains("@") && password.length > 2)
    }
}