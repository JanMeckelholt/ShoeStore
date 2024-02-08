package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailScreenViewModel : ViewModel() {
    var shoe = MutableLiveData<Shoe>()

    init {
        shoe = MutableLiveData(Shoe(company = "Nike", name = "Pegasus 35", size = 10.0, description = "Running Shoe", images = listOf<String>("")))
    }
}