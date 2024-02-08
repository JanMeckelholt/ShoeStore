package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.ViewModel
import timber.log.Timber

class WelcomeScreenViewModel : ViewModel() {
   init {
       Timber.i("initialized")
   }
    override fun onCleared() {
        super.onCleared()
        Timber.i("cleared")
    }
}